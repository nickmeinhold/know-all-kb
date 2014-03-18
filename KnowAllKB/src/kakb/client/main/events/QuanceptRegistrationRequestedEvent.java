package kakb.client.main.events;

import com.google.gwt.event.shared.GwtEvent;

public class QuanceptRegistrationRequestedEvent extends GwtEvent<QuanceptRegistrationRequestedEventHandler> {

	public static Type<QuanceptRegistrationRequestedEventHandler> TYPE = new Type<QuanceptRegistrationRequestedEventHandler>();
	
	String symbolStr;
	
	public QuanceptRegistrationRequestedEvent(String symbolStr) {
		this.symbolStr = symbolStr;
	}

	public String getSymbolStr() {
		return symbolStr;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<QuanceptRegistrationRequestedEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(QuanceptRegistrationRequestedEventHandler handler) {
		handler.onQuanceptRegistrationRequested(this);
	}
	
}
