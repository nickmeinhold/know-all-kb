package kakb.client.users.events;

import com.google.gwt.event.shared.GwtEvent;

public class ProfileInfoSubmittedEvent extends GwtEvent<ProfileInfoSubmittedEventHandler> {

	public static Type<ProfileInfoSubmittedEventHandler> TYPE = new Type<ProfileInfoSubmittedEventHandler>();
	
	String firstName;
	String lastName;
	
	public ProfileInfoSubmittedEvent(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ProfileInfoSubmittedEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ProfileInfoSubmittedEventHandler handler) {
		handler.onProfileInfoSubmitted(this);
	}
	
}
