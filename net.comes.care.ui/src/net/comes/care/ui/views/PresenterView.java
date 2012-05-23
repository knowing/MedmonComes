package net.comes.care.ui.views;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import net.comes.care.ui.Activator;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class PresenterView {

	public static final String ID = "net.comes.care.ui.view.presenter";

	private Image sampleImage;

	@PostConstruct
	protected void createContent(Composite parent) {
		Composite container = new Composite(parent, SWT.BORDER);
		container.setLayout(new FillLayout());
		

		ImageDescriptor imgDescr = Activator.getImageDescriptor("img/sample_data.jpg");
		sampleImage = imgDescr.createImage();
		Canvas canvas = new Canvas(container, SWT.NULL);
		
		canvas.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				e.gc.drawImage(sampleImage, 0, 0);
			}
		});
	}

	@PreDestroy
	protected void dispose() {
		if (sampleImage != null && !sampleImage.isDisposed())
			sampleImage.dispose();
	}

}
