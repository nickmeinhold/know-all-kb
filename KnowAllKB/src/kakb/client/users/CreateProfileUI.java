package kakb.client.users;

import kakb.client.KnowAllKB;
import kakb.client.users.events.ProfileInfoSubmittedEvent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class CreateProfileUI extends Composite {

	private static CreateProfileUIUiBinder uiBinder = GWT.create(CreateProfileUIUiBinder.class);
	@UiField Button submitBtn;
	@UiField TextBox firstNameTB;
	@UiField TextBox lastNameTB;

	interface CreateProfileUIUiBinder extends UiBinder<Widget, CreateProfileUI> {
	}

	public CreateProfileUI() {
		
		initWidget(uiBinder.createAndBindUi(this));

		
	}
	
	@UiHandler("submitBtn")
	void onSubmitBtnClick(ClickEvent event) {
		KnowAllKB.getEventBus().fireEvent(new ProfileInfoSubmittedEvent(firstNameTB.getText(), lastNameTB.getText()));
	}
}
