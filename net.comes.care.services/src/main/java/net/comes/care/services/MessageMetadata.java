package net.comes.care.services;

import java.util.Date;
import java.util.HashMap;

import net.comes.care.ws.sycare.AMessage;

/**
 * Metadata of {@link AMessage} class. 
 * 
 * Additional information which aren't accessible through the
 * AMessage class. 
 * 
 * @author Nepomuk Seiler
 *
 */
public class MessageMetadata {
	
	public static final String RECEIVE_DATE = "receive.date";
	public static final String READ_STATUS = "read.status"; 

	private final HashMap<String, Object> metadata = new HashMap<>();
	private final AMessage message;
	
	public MessageMetadata(AMessage message) {
		this.message = message;
	}

	public Date getReceiveDate() {
		return (Date) metadata.get(RECEIVE_DATE);
	}
	
	public void setReceiveDate(Date date) {
		metadata.put(RECEIVE_DATE, date);
	}

	public boolean getReadStatus() {
		if(!metadata.containsKey(READ_STATUS))
			return false;
		return (boolean) metadata.get(READ_STATUS);
	}
	
	public void setReadStatus(boolean status) {
		metadata.put(READ_STATUS, status);
	}
	
	public AMessage getMessage() {
		return message;
	}
	
	public HashMap<String, Object> getMetadata() {
		return metadata;
	}

	public boolean isEmpty() {
		return metadata.isEmpty();
	}
	
}
