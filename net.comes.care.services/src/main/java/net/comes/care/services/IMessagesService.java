package net.comes.care.services;

import java.util.List;

import net.comes.care.ws.sycare.AMessage;

public interface IMessagesService {

	public List<AMessage> getMessages();
	
	public List<AMessage> getMessages(String search);
	
	public List<AMessage> getMessages(int limit);
	
	public void persist(AMessage message);
	
	public void remove(AMessage message);
} 
