package kakb.shared.quancepts;

import com.google.gwt.user.client.rpc.IsSerializable;

public class QuanceptDTO implements IsSerializable {

	String id; 
	String symbolStr; 
	
	public QuanceptDTO() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSymbolStr() {
		return symbolStr;
	}

	public void setSymbolStr(String symbolStr) {
		this.symbolStr = symbolStr;
	}
	
	
}
