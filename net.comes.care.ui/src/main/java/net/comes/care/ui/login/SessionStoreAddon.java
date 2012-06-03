 
package net.comes.care.ui.login;

import javax.inject.Inject;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.e4.core.contexts.IEclipseContext;

public class SessionStoreAddon {
	
	@Inject
	IEclipseContext context;
	
	@PostConstruct
	void hookListeners() {
		context.set(SessionStore.class, new SessionStore());
	}
	
	@PreDestroy
	void unhookListeners() {
		context.remove(SessionStore.class);
	}
}