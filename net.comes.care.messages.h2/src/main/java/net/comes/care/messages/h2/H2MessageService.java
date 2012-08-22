package net.comes.care.messages.h2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import net.comes.care.messages.h2.model.Message;
import net.comes.care.messages.h2.model.User;
import net.comes.care.services.IMessagesService;
import net.comes.care.services.MessageMetadata;
import net.comes.care.ws.sycare.AMessage;
import net.comes.care.ws.sycare.MessageType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class H2MessageService implements IMessagesService {

	private final Logger log = LoggerFactory.getLogger(H2MessageService.class);

	private EntityManagerFactory emf;

	private User user; // Login!

	protected void activate() {
		// TODO no user authentication!
		log.info("H2 message service activated");
	}

	public boolean login(String usermail) {
		//Logout
		if(usermail == null | usermail.isEmpty()) {
			user = null;
			return true;
		}
		
		//Login
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<User> users = em.createNamedQuery("User.byEmail", User.class)
				.setParameter("email", usermail)
				.getResultList();
		if(users.isEmpty()) {
			user = new User();
			user.setEmail(usermail);
			em.persist(user);
			em.getTransaction().commit();
		} else {
			this.user = users.get(0);
		}
		
		em.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AMessage> getMessages() {
		if (user == null)
			return Collections.EMPTY_LIST;
		EntityManager em = emf.createEntityManager();
		List<Message> messages = em.find(User.class, user.getId()).getMessages();
		em.close();
		
		return convertFrom(messages);
	}

	@Override
	public List<AMessage> getMessages(String search) {
		//TODO Created fulltext search string
		return null;
	}

	@Override
	public void persist(AMessage aMessage) {
		if(user == null)
			throw new NullPointerException("Not logged in with any user.");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Message message = new Message();
		message.setMessageId(aMessage.getMessageId());
		message.setMessageType(aMessage.getMessageType());
		message.setContent(aMessage.getMessageData());
		message.setTitle(aMessage.getMessageTitle());
		message.setTimestamp(new Date());
		em.find(User.class, user.getId()).addMessage(message);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remove(AMessage message) {
		if(user == null)
			throw new NullPointerException("Not logged in with any user.");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, this.user.getId());
		Message dbMessage = findMessage(message, em);
		user.removeMessage(dbMessage);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public MessageMetadata getMetadata(AMessage message) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Message dbMessage = findMessage(message, em);
		MessageMetadata metadata = new MessageMetadata(message);
		metadata.setReceiveDate(dbMessage.getTimestamp());
		
		em.close();
		return metadata;
	}
	
	private Message findMessage(AMessage message, EntityManager em) {
		User user = em.find(User.class, this.user.getId());
		
		List<Message> messages = em.createNamedQuery("Message.byUserAndMessageId", Message.class)
			.setParameter("messageId", message.getMessageId())
			.setParameter("user", user)
			.getResultList();
		
		if(messages == null || messages.isEmpty())
			throw new RuntimeException("Database is not in sync. Message was not found for " + user.getEmail() + " with messageId " + message.getMessageId());
		if(messages.size() > 1)
			throw new RuntimeException("Too many messages found for user " + user.getEmail() + " with messageId " + message.getMessageId());
		
		return messages.get(0);
	}

	private List<AMessage> convertFrom(List<Message> messages) {
		List<AMessage> returns = new ArrayList<>(messages.size());
		for (Message msg : messages)
			returns.add(convertFrom(msg));
		return returns;
	}

	private AMessage convertFrom(Message message) {
		AMessage aMessage = new AMessage();
		aMessage.setMessageData(message.getContent());
		aMessage.setMessageTitle(message.getTitle());
		aMessage.setMessageType(MessageType.fromValue(message.getMessageType()));
		aMessage.setMessageId(message.getMessageId());
		return aMessage;
	}


	protected void bindEntityManagerFactory(EntityManagerFactory emf, Map<String, String> properties) {
		this.emf = emf;
	}

	protected void unbindEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = null;
	}

}
