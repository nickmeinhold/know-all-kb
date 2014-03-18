package kakb.client.users;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;

public class ProfileHeaderUI extends Composite {

	private static ProfileHeaderUIUiBinder uiBinder = GWT.create(ProfileHeaderUIUiBinder.class);
	@UiField Label nameLbl;

	interface ProfileHeaderUIUiBinder extends UiBinder<Widget, ProfileHeaderUI> {
	}

	public ProfileHeaderUI(String firstName, String lastName) {
		initWidget(uiBinder.createAndBindUi(this));
		nameLbl.setText(firstName + " " + lastName);
	}

}
