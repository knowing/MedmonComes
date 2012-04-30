package net.comes.care.ui.views;

import java.io.ByteArrayInputStream;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import net.comes.care.ui.Activator;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.gemini.ext.di.GeminiPersistenceContext;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.osgi.internal.signedcontent.Base64;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * 
 * @author Nepomuk Seiler
 * @since 2012-04-28
 * @see https
 *      ://github.com/toedter/e4-rendering/blob/master/com.toedter.e4.demo.contacts
 *      .swt/src/com/toedter/e4/demo/contacts/swt/views/DetailComposite.java
 * 
 */
public class PatientView {

	public static final String ID = "net.comes.care.ui.view.patient";

	@Inject
	@GeminiPersistenceContext(unitName = "comes")
	private EntityManager em;

	private DataBindingContext dbc;
	private IObservableValue scaledImage;
	private final WritableValue contactValue = new WritableValue();
	private Image dummyPortrait;

	private Label imageLabel;

	@PostConstruct
	protected void createContent(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		dbc = new DataBindingContext();
		container.setLayout(new GridLayout(3, false));

		Label lblLastName = new Label(container, SWT.NONE);
		lblLastName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLastName.setText("Nachname");

		Text txtLastName = new Text(container, SWT.BORDER);
		txtLastName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		imageLabel = new Label(container, SWT.BORDER | SWT.SHADOW_IN);
		imageLabel.setAlignment(SWT.CENTER);
		GridData gd_imgPatient = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 3);
		gd_imgPatient.heightHint = 120;
		gd_imgPatient.widthHint = 120;
		imageLabel.setLayoutData(gd_imgPatient);
		imageLabel.setText("<image>");
		dummyPortrait = Activator.getImageDescriptor("icons/256/stock_person.png").createImage();

		Label lblFirstName = new Label(container, SWT.NONE);
		lblFirstName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFirstName.setText("Vorname");
		Text txtFirstName = new Text(container, SWT.BORDER);
		txtFirstName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblInsuranceId = new Label(container, SWT.NONE);
		lblInsuranceId.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblInsuranceId.setText("VersicherungsNr.");
		Text txtInsuranceId = new Text(container, SWT.BORDER);
		txtInsuranceId.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));

		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		//TODO this is just a short snippet used from Kai Toedter. Use databindings everywhere
		// Bind the image
		final IObservableValue imageObservableValue = PojoObservables.observeDetailValue(contactValue, "jpegString", String.class);

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
}
