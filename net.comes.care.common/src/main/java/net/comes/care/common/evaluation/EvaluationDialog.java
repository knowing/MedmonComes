package net.comes.care.common.evaluation;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.TypedActor;
import akka.actor.TypedProps;
import akka.japi.Creator;

import com.typesafe.config.ConfigFactory;

import de.lmu.ifi.dbs.knowing.core.events.Shutdown;
import de.lmu.ifi.dbs.knowing.core.events.Status;
import de.lmu.ifi.dbs.knowing.core.factory.UIFactory;
import de.lmu.ifi.dbs.knowing.core.service.IActorSystemManager;
import de.lmu.ifi.dbs.knowing.core.swt.factory.TabUIFactory;

/**
 * 
 * @author Nepomuk Seiler
 * 
 */
public class EvaluationDialog extends Dialog {

	public static final String UIFACTORY_ID = "net.comes.care.patient.evaluation.Dialog";
	private final IActorSystemManager asm;

	private UIFactory<Composite> uiFactory;
	private ActorSystem system;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public EvaluationDialog(Shell parentShell, IActorSystemManager asm) {
		super(parentShell);
		this.asm = asm;
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

		system = asm.create("swt-default", ConfigFactory.defaultReference(ActorSystem.class.getClassLoader()));
//		uiFactory = UIFactories.newTabUIFactoryInstance(system, parent, UIFACTORY_ID);
		uiFactory = TypedActor.get(system).typedActorOf(new TypedProps<TabUIFactory>(UIFactory.class, new Creator<TabUIFactory>() {
			public TabUIFactory create() {
				return new TabUIFactory(parent, UIFACTORY_ID, SWT.BOTTOM) {
					@Override
					public void update(ActorRef actor, Status status) {
						if(status instanceof Shutdown)
							onFinish();
						super.update(actor, status);
					}
				};
			}
		}), "name");
		return container;
	}

	@Override
	public boolean close() {
		TypedActor.get(system).stop(uiFactory);
		uiFactory = null;
		return super.close();
	}
	
	private void onFinish() {
		System.err.println("FINISH IT!");
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

}
