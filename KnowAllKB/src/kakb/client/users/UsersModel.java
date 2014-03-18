package kakb.client.users;

import kakb.shared.users.UserProfileDTO;

public class UsersModel {
	
	UserProfileDTO userProfileDTO;
	
	public UsersModel() {
		userProfileDTO = null;
	}

	public UserProfileDTO getUserProfileDTO() {
		return userProfileDTO;
	}

	public void setUserProfileDTO(UserProfileDTO userProfileDTO) {
		this.userProfileDTO = userProfileDTO;
	}
	
	

}
