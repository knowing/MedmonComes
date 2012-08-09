package net.comes.care.common.ui;

import java.util.LinkedList;

import javax.xml.ws.soap.SOAPFaultException;

import net.comes.care.ws.sycare.AMessage;
import net.comes.care.ws.sycare.GetMessageRequest;
import net.comes.care.ws.sycare.MessageOption;
import net.comes.care.ws.sycare.Scroll;
import net.comes.care.ws.sycare.Sycare;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

public class MessageViewer extends TableViewer {

	public MessageViewer(Composite parent, int style) {
		super(parent, style);
		initColumns();
		setContentProvider(new ArrayContentProvider());
		setLabelProvider(new MessageLabelProvider());
		getTable().setLinesVisible(true);
		getTable().setHeaderVisible(true);
	}

	/**
	 * select | Header | From
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
	}

	public void setInput(Sycare sycare, String sessionId) {
		LinkedList<AMessage> messages = new LinkedList<>();
		GetMessageRequest parameters = new GetMessageRequest();
		parameters.setSessionId(sessionId);
		AMessage msg = sycare.getMessage(parameters);

		// TODO This smells for deadlock
		int i = 1;
		while (true) {
			try {
				if(msg == null)
					break;
				messages.add(msg);
				
				MessageOption option = new MessageOption();
				Scroll scroll = new Scroll();
				scroll.setIncrement(i++); // Is that the way it should work?
				parameters.setMessageOption(option);
				msg = sycare.getMessage(parameters);
				
			} catch (SOAPFaultException e) {
				// no more messages
				break;
			}
		}
		setInput(messages);
	}

	public class MessageLabelProvider extends LabelProvider implements ITableLabelProvider {

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
				return "Unbekannt";
			}
			return null;
		}

	}

}
