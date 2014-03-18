package kakb.client.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;

import kakb.client.KnowAllKB;
import kakb.client.QuanceptsServiceAsync;
import kakb.shared.quancepts.QuanceptDTO;
import kakb.client.main.events.QuanceptRegistrationRequestedEvent;
import kakb.client.main.events.QuanceptRegistrationRequestedEventHandler;

public class MainController {

	MainModel model;
	MainView view;
	QuanceptsServiceAsync quanceptsService;
	
	public MainController(QuanceptsServiceAsync quanceptsService0) {
		
		Map<String, String> quanceptsMap = new HashMap<String, String>();
		MultiWordSuggestOracle quanceptsOracle = new MultiWordSuggestOracle();
		
		model = new MainModel(quanceptsMap, quanceptsOracle);
		view = new MainView(quanceptsMap, quanceptsOracle);
		quanceptsService = quanceptsService0;
		
		quanceptsService.retrieveQuancepts(new AsyncCallback<List<QuanceptDTO>>() {

			public void onFailure(Throwable caught) {
				Window.alert("Error retrieving all quancept names");
			}

			public void onSuccess(List<QuanceptDTO> result) {
				model.loadModel(result);
			}
			
		});
		
		KnowAllKB.getEventBus().addHandler(QuanceptRegistrationRequestedEvent.TYPE, new QuanceptRegistrationRequestedEventHandler() {

			@Override
			public void onQuanceptRegistrationRequested(QuanceptRegistrationRequestedEvent event) {
				
				QuanceptDTO dto = new QuanceptDTO();
				dto.setSymbolStr(event.getSymbolStr());
				quanceptsService.registerQuancept(dto, new AsyncCallback<QuanceptDTO>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Error registering quancept from Suggest Box");
					}

					@Override
					public void onSuccess(QuanceptDTO result) {
						model.addToModel(result);
					}
					
				});
				
			}
			
		});
		
	}
	
	public MainView getView() {
		return view;
	}
	
	public void giveFocus() {
		view.giveFocus();
	}
	
}
