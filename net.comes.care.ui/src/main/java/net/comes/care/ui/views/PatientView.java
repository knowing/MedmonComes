package net.comes.care.ui.views;

import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import net.comes.care.common.preferences.PatientPreferences;
import net.comes.care.common.resources.ISharedImages;
import net.comes.care.common.resources.ResourceManager;
import net.comes.care.entity.Patient;
import net.comes.care.ui.search.PatientContentAssistenProcessor;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.gemini.ext.di.GeminiPersistenceContext;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.contentassist.ContentAssistEvent;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ICompletionListener;
import org.eclipse.jface.text.contentassist.ICompletionListenerExtension2;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.osgi.internal.signedcontent.Base64;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.osgi.service.prefs.BackingStoreException;

import com.google.common.base.Splitter;

import de.lmu.ifi.dbs.medmon.sensor.core.ISensorDirectoryService;

/**
 * 
 * @author Nepomuk Seiler
 * @since 2012-04-28
 * @see https
 *      ://github.com/toedter/e4-rendering/blob/master/com.toedter.e4.demo.
 *      contacts
 *      .swt/src/com/toedter/e4/demo/contacts/swt/views/DetailComposite.java
 * 
 */
public class PatientView {

	public static final String ID = "net.comes.care.ui.view.patient";

	@Inject
	@GeminiPersistenceContext(unitName = "comes")
	private EntityManager em;

	@Inject
	private ISensorDirectoryService sensorDirectory;

	@Inject
	@Preference(nodePath = PatientPreferences.NODE_PATH)
	private IEclipsePreferences preferences;
	
	@Inject
	private ESelectionService selectionService;

	private DataBindingContext dbc;
	private IObservableValue scaledImage;
	private final WritableValue patientValue = new WritableValue();
	private Image dummyPortrait;

	private Button btnImport;
	private Label imageLabel;
	private Text txtLastName, txtFirstName, txtInsuranceId,txtPatientGroup;
	private TextViewer txtSearch;

	@PostConstruct
	protected void createContent(final Composite parent, PatientContentAssistenProcessor processor, final EHandlerService handlerService,
			final ECommandService commandService) {
		Composite container = new Composite(parent, SWT.BORDER);
		container.setLayout(new GridLayout(3, false));

		Label lblSearch = new Label(container, SWT.NONE);
		lblSearch.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSearch.setText("Suche");

		createSearch(container, processor);

		Label lblLastName = new Label(container, SWT.NONE);
		lblLastName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLastName.setText("Nachname");

		txtLastName = new Text(container, SWT.BORDER);
		txtLastName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		imageLabel = new Label(container, SWT.BORDER | SWT.SHADOW_IN);
		imageLabel.setAlignment(SWT.CENTER);
		GridData gd_imgPatient = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 4);
		gd_imgPatient.heightHint = 120;
		gd_imgPatient.widthHint = 120;
		imageLabel.setLayoutData(gd_imgPatient);
		imageLabel.setText("<image>");
		
		dummyPortrait = ResourceManager.getPluginImage(ISharedImages.PLUGIN_ID, ISharedImages.ICON_PERSON_STOCK_256);
		Label lblFirstName = new Label(container, SWT.NONE);
		lblFirstName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFirstName.setText("Vorname");
		txtFirstName = new Text(container, SWT.BORDER);
		txtFirstName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblInsuranceId = new Label(container, SWT.NONE);
		lblInsuranceId.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblInsuranceId.setText("VersicherungsNr.");
		txtInsuranceId = new Text(container, SWT.BORDER);
		txtInsuranceId.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		
		Label lblPatientGroup = new Label(container, SWT.NONE);
		lblPatientGroup.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblPatientGroup.setText("Gruppe");
		
		txtPatientGroup = new Text(container, SWT.BORDER);
		txtPatientGroup.setText("Group");
		txtPatientGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		
		Composite cButtons = new Composite(container, SWT.NONE);
		cButtons.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, true, 3, 1));
		cButtons.setLayout(new RowLayout());

		btnImport = new Button(cButtons, SWT.PUSH);
		btnImport.setImage(ResourceManager.getPluginImage(ISharedImages.PLUGIN_ID, ISharedImages.IMG_IMPORT));
		btnImport.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ParameterizedCommand cmd = commandService.createCommand("net.comes.care.ui.data.import", null);
				handlerService.executeHandler(cmd);
			}
		});
		btnImport.setEnabled(false);

		Button btnComes = new Button(cButtons, SWT.PUSH);
		btnComes.setImage(ResourceManager.getPluginImage(ISharedImages.PLUGIN_ID, ISharedImages.IMG_COMES_LOGO_FLAT));
		btnComes.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ParameterizedCommand cmd = commandService.createCommand("net.comes.care.ui.comesLoginCommand", null);
				handlerService.executeHandler(cmd);
			}
		});

		bindValues();
		loadPatient(preferences.getInt(PatientPreferences.LAST_PATIENT_ID, 0));
	}

	@Focus
	protected void focus() {
		txtSearch.getControl().setFocus();
	}

	private void bindValues() {
		dbc = new DataBindingContext();

		// Bind lastname
		ISWTObservableValue lastNameTarget = WidgetProperties.text(SWT.Modify).observe(txtLastName);
		IObservableValue lastNameModel = PojoProperties.value("user.surname").observeDetail(patientValue);
		dbc.bindValue(lastNameTarget, lastNameModel);

		// Bind firstname
		ISWTObservableValue firstNameTarget = WidgetProperties.text(SWT.Modify).observe(txtFirstName);
		IObservableValue firstNameModel = PojoProperties.value("user.name").observeDetail(patientValue);
		dbc.bindValue(firstNameTarget, firstNameModel);

		// Bind insurance id
		ISWTObservableValue insuranceIdTarget = WidgetProperties.text(SWT.Modify).observe(txtInsuranceId);
		IObservableValue insuranceIdModel = PojoProperties.value("insuranceNumber").observeDetail(patientValue);
		dbc.bindValue(insuranceIdTarget, insuranceIdModel);
		
		// Bind patient group
		ISWTObservableValue patientGroupTarget = WidgetProperties.text(SWT.Modify).observe(txtPatientGroup);
		IObservableValue patientGroupModel = PojoProperties.value("patientGroup.name").observeDetail(patientValue);
		dbc.bindValue(patientGroupTarget, patientGroupModel);
		

		// Binding the patient image
		final IObservableValue imageObservableValue = PojoObservables.observeDetailValue(patientValue, "jpegString", String.class);
		this.scaledImage = new ComputedValue() {
			private Image currentImage;

			@Override
			protected Object calculate() {
				String jpegString = (String) imageObservableValue.getValue();
				Image image = null;
				if (jpegString == null) {
					image = dummyPortrait;
				} else {
					byte[] imageBytes = Base64.decode(jpegString.getBytes());
					ByteArrayInputStream is = new ByteArrayInputStream(imageBytes);
					ImageData imageData = new ImageData(is);
					image = new Image(Display.getCurrent(), imageData);
				}
				ImageData imageData = image.getImageData();
				double ratio = imageData.height / 85.0;
				int width = (int) (imageData.width / ratio);
				int height = (int) (imageData.height / ratio);
				ImageData scaledImageData = imageData.scaledTo(width, height);
				if (currentImage != null) {
					currentImage.dispose();
					currentImage = null;
				}
				currentImage = new Image(Display.getCurrent(), scaledImageData);
				return currentImage;
			}

			@Override
			public void dispose() {
				if (currentImage != null) {
					currentImage.dispose();
					currentImage = null;
				}
				super.dispose();
			}

		};
		dbc.bindValue(SWTObservables.observeImage(imageLabel), scaledImage, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
	}

	private void createSearch(Composite container, PatientContentAssistenProcessor processor) {
		txtSearch = new TextViewer(container, SWT.BORDER | SWT.SINGLE | SWT.SEARCH);
		txtSearch.getControl().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		txtSearch.setDocument(new Document());

		final ContentAssistant assistant = new ContentAssistant();
		assistant.setContentAssistProcessor(processor, IDocument.DEFAULT_CONTENT_TYPE);
		assistant.enableAutoActivation(true);
		assistant.setAutoActivationDelay(200); // Test this
		assistant.install(txtSearch);
		assistant.addCompletionListener(new CompletionListener());
	}

	private void loadPatient(int id) {
		if (id < 1)
			return;
		Patient patient = em.find(Patient.class, id);
		updatePatient(patient);
	}

	private void loadPatient(String fullSearch) {
		Splitter s1 = Splitter.on('#').omitEmptyStrings();
		Iterator<String> itPatientInsurance = s1.split(fullSearch).iterator();
		String patientString = itPatientInsurance.next();
		String insuranceId = itPatientInsurance.next();

		// This is for testing. Normally you would load the patient here
		List<Patient> resultList = em.createQuery("SELECT p FROM Patient p WHERE p.insuranceNumber = :insuranceId")
				.setParameter("insuranceId", insuranceId).getResultList();

		// Assuming insuranceId is unique
		Patient patient = resultList.get(0);
		updatePatient(patient);
	}

	private void updatePatient(Patient patient) {
		patientValue.setValue(patient);
		preferences.putInt(PatientPreferences.LAST_PATIENT_ID, patient.getId());
		selectionService.setSelection(patient);
		btnImport.setEnabled(true);
		try {
			preferences.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

	private class CompletionListener implements ICompletionListener, ICompletionListenerExtension2 {

		@Override
		public void applied(ICompletionProposal proposal) {
			loadPatient(proposal.getDisplayString());
		}

		@Override
		public void assistSessionStarted(ContentAssistEvent event) {
		}

		@Override
		public void assistSessionEnded(ContentAssistEvent event) {
		}

		@Override
		public void selectionChanged(ICompletionProposal proposal, boolean smartToggle) {
			// this works only with keyboard
		}

	}

}
