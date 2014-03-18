package kakb.client.users.events;

import com.google.gwt.event.shared.EventHandler;

public interface ProfileInfoSubmittedEventHandler extends EventHandler {

	void onProfileInfoSubmitted(ProfileInfoSubmittedEvent event);
	
}
