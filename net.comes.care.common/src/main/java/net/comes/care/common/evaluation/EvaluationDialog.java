package net.comes.care.common.evaluation;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

import akka.actor.ActorPath;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.TypedActor;
import akka.actor.TypedProps;
import akka.japi.Creator;

import com.typesafe.config.ConfigFactory;

import de.lmu.ifi.dbs.knowing.core.events.Created;
import de.lmu.ifi.dbs.knowing.core.events.ExceptionEvent;
import de.lmu.ifi.dbs.knowing.core.events.Finished;
import de.lmu.ifi.dbs.knowing.core.events.Progress;
import de.lmu.ifi.dbs.knowing.core.events.Ready;
import de.lmu.ifi.dbs.knowing.core.events.Running;
import de.lmu.ifi.dbs.knowing.core.events.Shutdown;
import de.lmu.ifi.dbs.knowing.core.events.Status;
import de.lmu.ifi.dbs.knowing.core.events.UpdateUI;
import de.lmu.ifi.dbs.knowing.core.factory.UIFactory;
import de.lmu.ifi.dbs.knowing.core.service.IActorSystemManager;
import de.lmu.ifi.dbs.knowing.core.swt.factory.TabUIFactory;

/**
 * 
 * @author Nepomuk Seiler
 * 
 */
@Creatable
public class EvaluationDialog extends Dialog {

	public static final String UIFACTORY_ID = "net.comes.care.patient.evaluation.Dialog";
	public static final String FINISH_EVENT_TOPIC = "de/lmu/ifi/dbs/knowing/core/evaluation/finish";
	public static final String ERROR_EVENT_TOPIC = "de/lmu/ifi/dbs/knowing/core/evaluation/error";

	private final IEventBroker broker;
	private final IActorSystemManager asm;
	private final Map<ActorPath, Double> progressMap;

	private UIFactory<Composite> uiFactory;
	private ActorSystem system;
	private ProgressBar progressBar;
	
	private String targetFile;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	@Inject
	public EvaluationDialog(Shell parentShell, IActorSystemManager asm, IEventBroker broker) {
		super(parentShell);
		this.asm = asm;
		this.broker = broker;
		progressMap = new HashMap<>();
		setBlockOnOpen(false);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(final Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(1, false));
		progressBar = new ProgressBar(container, SWT.NONE);
		progressBar.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		system = asm.create("swt-default", ConfigFactory.defaultReference(ActorSystem.class.getClassLoader()));
		// uiFactory = UIFactories.newTabUIFactoryInstance(system, parent,
		// UIFACTORY_ID);
		uiFactory = TypedActor.get(system).typedActorOf(new TypedProps<TabUIFactory>(UIFactory.class, new Creator<TabUIFactory>() {
			public TabUIFactory create() {
				return new TabUIFactory(parent, UIFACTORY_ID, SWT.BOTTOM) {
					@Override
					public void update(ActorRef actor, Status status) {
						if (status instanceof Shutdown)
							parent.getDisplay().asyncExec(new Runnable() {
								@Override
								public void run() {
									onFinish();
								}
							});
						else if (status instanceof UpdateUI)
							parent.getDisplay().asyncExec(new Runnable() {
								@Override
								public void run() {
									updateUI();
								}
							});
						else
							updateProgress(actor, status);
					}
				};
			}
		}), "EvaluationDialog-UIFactory");
		return container;
	}

	@Override
	public boolean close() {
		TypedActor.get(system).stop(uiFactory);
		uiFactory = null;
		return super.close();
	}

	private void updateProgress(final ActorRef actor, final Status status) {
		progressBar.getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				if (status instanceof Created)
					progressMap.put(actor.path(), 0.0);
				else if (status instanceof Running)
					;
				else if (status instanceof Finished || status instanceof Ready)
					progressMap.put(actor.path(), 1.0);
				else if (status instanceof Progress) {
					Progress p = (Progress) status;
					double worked = p.worked();
					double work = p.work();
					progressMap.put(actor.path(), (worked / work));
				} else if (status instanceof ExceptionEvent) {
					ExceptionEvent ex = (ExceptionEvent) status;
					broker.post(ERROR_EVENT_TOPIC, ex.throwable());
				}

				progressBar.setMaximum(progressMap.size() * 100);
				int selection = 0;
				for (Double d : progressMap.values()) {
					selection += d * 100.00;
				}
				progressBar.setSelection(selection);
			}
		});
	}

	private void onFinish() {
		broker.post(FINISH_EVENT_TOPIC, targetFile);
		close();
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		// createButton(parent, IDialogConstants.OK_ID,
		// IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	public UIFactory<Composite> getUiFactory() {
		return uiFactory;
	}

	public ActorSystem getSystem() {
		return system;
	}
	
	public String getTargetFile() {
		return targetFile;
	}
	
	public void setTargetFile(String targetFile) {
		this.targetFile = targetFile;
	}

}
