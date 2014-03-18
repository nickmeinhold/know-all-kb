package kakb.server;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import kakb.client.UsersService;
import kakb.server.users.UserProfileDAO;
import kakb.shared.users.UserProfileDTO;

import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class UsersServiceImpl extends RemoteServiceServlet implements UsersService {

	//Start UserService Sessions 
	com.google.appengine.api.users.UserService userService = UserServiceFactory.getUserService();
		
	@Override
	public UserProfileDTO retrieveUserProfile() {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		UserProfileDTO profileDTO;
		String googleId = userService.getCurrentUser().getUserId();
		
		Query query = pm.newQuery(UserProfileDAO.class, "googleId == :gid");
		query.setUnique(true);
		UserProfileDAO profileDAO = (UserProfileDAO)query.execute(googleId);
		
		pm.close();
		
		if (profileDAO == null) {
			profileDTO = null;
		}
		else {
			profileDTO = profileDAO.toDTO();
		}
		
		return profileDTO;
		
	}

	@Override
	public UserProfileDTO storeUserDetails(UserProfileDTO dto) {
		
		UserProfileDAO dao = new UserProfileDAO(dto);
		dao.setGoogleId(userService.getCurrentUser().getUserId());
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		pm.makePersistent(dao);
		
		pm.close();
		
		return dao.toDTO();
	}
	
}
