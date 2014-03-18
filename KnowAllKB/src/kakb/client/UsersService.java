package kakb.client;

import kakb.shared.users.UserProfileDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("users")
public interface UsersService extends RemoteService {
	
	UserProfileDTO retrieveUserProfile();
	UserProfileDTO storeUserDetails(UserProfileDTO dto);
	
}
