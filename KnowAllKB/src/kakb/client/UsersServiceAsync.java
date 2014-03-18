package kakb.client;

import kakb.shared.users.UserProfileDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UsersServiceAsync {

	void retrieveUserProfile(AsyncCallback<UserProfileDTO> callback);
	void storeUserDetails(UserProfileDTO dto, AsyncCallback<UserProfileDTO> callback);
	
}
