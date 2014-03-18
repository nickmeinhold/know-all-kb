package kakb.shared.users;

import com.google.gwt.user.client.rpc.IsSerializable;

public class UserProfileDTO implements IsSerializable {

	String id;
	String firstName;
	String lastName;
	
	public UserProfileDTO() {
		this.id = null;
	}
	
	public UserProfileDTO(String firstName, String lastName) {
		this();
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
