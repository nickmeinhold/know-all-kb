package kakb.client.main;

import java.util.Map;

import kakb.client.KnowAllKB;
import kakb.client.main.events.QuanceptRegistrationRequestedEvent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainView extends Composite {

	private static MainUIUiBinder uiBinder = GWT.create(MainUIUiBinder.class);
	@UiField VerticalPanel mainPnl;
	
	SuggestBox suggestBox;
	Map<String, String> quanceptsMap;
	MultiWordSuggestOracle quanceptsOracle;

	interface MainUIUiBinder extends UiBinder<Widget, MainView> {
	}

	public MainView(Map<String, String> quanceptsMap0, MultiWordSuggestOracle quanceptsOracle0) {
		
		initWidget(uiBinder.createAndBindUi(this));
		
		quanceptsMap = quanceptsMap0;
		quanceptsOracle = quanceptsOracle0;
		
		this.setupSuggestBox();
		
	}
	
	public void setupSuggestBox() {
		
		this.suggestBox = new SuggestBox(quanceptsOracle);
		mainPnl.add(suggestBox);
		suggestBox.addSelectionHandler(new SelectionHandler<Suggestion>() {

			public void onSelection(SelectionEvent<Suggestion> event) {
				
				suggestBox.setText("");
				
				String suggestionStr = event.getSelectedItem().getReplacementString();
				String quanceptId = quanceptsMap.get(suggestionStr);
				
				mainPnl.add(new HTML(suggestionStr + " id: " + quanceptId));
				
			}
			
		});
		
		suggestBox.addKeyPressHandler(new KeyPressHandler() {

			@Override
			public void onKeyPress(KeyPressEvent event) {
				
				if(event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
					KnowAllKB.getEventBus().fireEvent(new QuanceptRegistrationRequestedEvent(suggestBox.getText()));
					suggestBox.setText("");
				}
				
			}
			
		});
		
	}
	
	public void giveFocus() {
		suggestBox.setFocus(true);
	}

}
