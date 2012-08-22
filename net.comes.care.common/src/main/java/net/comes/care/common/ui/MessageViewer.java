package net.comes.care.common.ui;

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
