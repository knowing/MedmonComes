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
		if(users.isEmpty())
			return false;
		this.user = users.get(0);
		em.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AMessage> getMessages() {
		//if(user == null) createMockData();

		if (user == null)
			return Collections.EMPTY_LIST;
		EntityManager em = emf.createEntityManager();
		List<Message> messages = em.find(User.class, user.getId()).getMessages();
		em.close();

		return convertFrom(messages);
	}

	@Override
	public List<AMessage> getMessages(String search) {
		// Created fulltext search string
		return null;
	}

	@Override
	public List<AMessage> getMessages(int limit) {
		EntityManager em = emf.createEntityManager();
		// TODO Limit for getMessages(int limit) method
		List<Message> messages = em.createNamedQuery("Message.byUser", Message.class).getResultList();
		em.close();
		return convertFrom(messages);
	}

	@Override
	public void persist(AMessage aMessage) {
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
		return aMessage;
	}

	private void createMockData() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User user = new User();
		user.setEmail("lucky@luke.ll");
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		this.user = user;

		AMessage msg1 = new AMessage();
		msg1.setMessageId(1);
		msg1.setMessageType(MessageType.HTML);
		msg1.setMessageTitle("Old Message One");
		msg1.setMessageData("<h1>Important</h1> Old message");
		persist(msg1);

		AMessage msg2 = new AMessage();
		msg2.setMessageId(1);
		msg2.setMessageType(MessageType.STRING);
		msg2.setMessageTitle("Old Message Two");
		msg2.setMessageData("Unformatted old message");
		persist(msg2);
	}

	protected void bindEntityManagerFactory(EntityManagerFactory emf, Map<String, String> properties) {
		this.emf = emf;
	}

	protected void unbindEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = null;
	}

}
