package net.comes.care.ui.login;

import com.google.common.base.Optional;

import net.comes.care.ws.sycare.Session;

public class SessionStore {

	private static SessionStore store;

	private Optional<Session> session;

	private SessionStore() {
	}

	public static SessionStore getInstance() {
		if (store == null)
			store = new SessionStore();
		return store;
	}

	public Optional<Session> getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = Optional.fromNullable(session);
	}

}
