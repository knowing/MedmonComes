package net.comes.care.common.login;

import javax.inject.Singleton;

import com.google.common.base.Optional;

import net.comes.care.ws.sycare.Session;

@Singleton
public class SessionStore {

	private Optional<Session> session = Optional.absent();
	private Optional<String> email = Optional.absent();

	protected SessionStore() {
	}

	public Optional<Session> getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = Optional.fromNullable(session);
	}

	public Optional<String> getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = Optional.fromNullable(email);
	}
	
	

}
