package net.comes.care.services;

import java.util.List;

import net.comes.care.ws.sycare.AMessage;

/**
 * Service to store received message. This could be a database, the filesystem
 * or some temporary in-memory  solution. 
 * 
 * @author Nepomuk Seiler
 * @version 0.1
 *
 */
public interface IMessagesService {
	
	/**
	 * Users are identified by their email. This is no authorization,
	 * but authentication process.
	 * 
	 * @param usermail
	 * @return true if login successfull
	 */
	public boolean login(String usermail);

	/**
	 * Depending on the implementation this could return all
	 * messages stored in the backing persistence storage or
	 * call the sycare soap service and fetches new ones, too.
	 * 
	 * <p>
	 * Normally messages should be persisted with <code>persist(AMessage message</code>.
	 * </p>
	 * 
	 * @return
	 */
	public List<AMessage> getMessages();
	
	/**
	 * Receive all messages matching the search pattern.
	 * The search pattern syntax depends on the implementation.
	 * 
	 * @see getMessages
	 * @param search
	 * @return
	 */
	public List<AMessage> getMessages(String search);
	
	
	/**
	 * Persists the message to the backing persistence implementation.
	 * @param message
	 */
	public void persist(AMessage message);
	
	/**
	 * Removes the message from the backing persistence implementation.
	 * @param message
	 */
	public void remove(AMessage message);
	
	/**
	 * 
	 * @param message
	 * @return
	 */
	public MessageMetadata getMetadata(AMessage message);
} 
