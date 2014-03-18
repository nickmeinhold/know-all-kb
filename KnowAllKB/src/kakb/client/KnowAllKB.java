package kakb.client;

import kakb.client.QuanceptsService;
import kakb.client.QuanceptsServiceAsync;
import kakb.client.UsersService;
import kakb.client.UsersServiceAsync;
import kakb.client.users.CreateProfileUI;
import kakb.client.users.ProfileHeaderUI;
import kakb.client.users.UsersModel;
import kakb.client.users.events.ProfileInfoSubmittedEvent;
import kakb.client.users.events.ProfileInfoSubmittedEventHandler;
import kakb.shared.users.UserProfileDTO;
import kakb.client.main.MainController;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class KnowAllKB implements EntryPoint {
	
	private final UsersServiceAsync usersService = GWT.create(UsersService.class);
	private final QuanceptsServiceAsync quanceptsService = GWT.create(QuanceptsService.class);
	private static final EventBus eventBus = new SimpleEventBus();
	private UsersModel usersModel = new UsersModel();
	private MainController mainController = new MainController(quanceptsService);
	
	Panel mainPnl = new VerticalPanel();
	
	public void onModuleLoad() {
		
		RootPanel.get("appgoeshere").add(mainPnl);
		
		usersService.retrieveUserProfile(new AsyncCallback<UserProfileDTO>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error retrieving user profile on module load.");
			}

			@Override
			public void onSuccess(UserProfileDTO result) {
				if(result == null) {
					mainPnl.add(new CreateProfileUI());
				}
				else {
					usersModel.setUserProfileDTO(result);
					loadMainUI();
				}
			}
			
		});
		
		
		
		eventBus.addHandler(ProfileInfoSubmittedEvent.TYPE, new ProfileInfoSubmittedEventHandler() {

			@Override
			public void onProfileInfoSubmitted(ProfileInfoSubmittedEvent event) {
				usersService.storeUserDetails(new UserProfileDTO(event.getFirstName(), event.getLastName()), new AsyncCallback<UserProfileDTO>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Error storing user details when submitted.");
					}

					@Override
					public void onSuccess(UserProfileDTO result) {
						usersModel.setUserProfileDTO(result);
						loadMainUI();
					}
					
				});
			}
			
		});
		
	}
	
	public static EventBus getEventBus(){
		return eventBus;
	}
	
	private void loadMainUI() {
		mainPnl.clear();
		mainPnl.add(new ProfileHeaderUI(usersModel.getUserProfileDTO().getFirstName(), usersModel.getUserProfileDTO().getLastName()));
		
		mainPnl.add(mainController.getView());
		mainController.giveFocus();
		
	}
}
