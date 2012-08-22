package net.comes.care.common.ui;

import java.text.DateFormat;

import net.comes.care.services.IMessagesService;
import net.comes.care.ws.sycare.AMessage;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

public class MessageViewer extends TableViewer {

	private final DateFormat df = DateFormat.getDateTimeInstance();
	
	private IMessagesService messagesService;

	public MessageViewer(Composite parent, int style) {
		super(parent, style);
		initColumns();
		setContentProvider(new ArrayContentProvider());
		setLabelProvider(new MessageLabelProvider());
		getTable().setLinesVisible(true);
		getTable().setHeaderVisible(true);
	}

	public void setMessagesService(IMessagesService messagesService) {
		this.messagesService = messagesService;
	}

	/**
	 * select | Header | From | Date
	 */
	private void initColumns() {
		TableViewerColumn col = new TableViewerColumn(this, SWT.CHECK);
		col.getColumn().setText("[]");
		col.getColumn().setWidth(20);

		col = new TableViewerColumn(this, SWT.LEAD);
		col.getColumn().setText("Kopfzeile");
		col.getColumn().setWidth(300);

		col = new TableViewerColumn(this, SWT.LEAD);
		col.getColumn().setText("Absender");
		col.getColumn().setWidth(200);

		col = new TableViewerColumn(this, SWT.LEAD);
		col.getColumn().setText("Abgerufen");
		col.getColumn().setWidth(200);
	}

	public class MessageLabelProvider extends LabelProvider implements
			ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			AMessage msg = (AMessage) element;
			switch (columnIndex) {
			case 1:
				return msg.getMessageTitle();
			case 2:
				return "Unbekannt-"; // TODO feature request for messages.
			case 3:
				if (messagesService == null)
					return "--";
				return df.format(messagesService.getMetadata(msg).getReceiveDate());
			}
			return null;
		}

	}

}
