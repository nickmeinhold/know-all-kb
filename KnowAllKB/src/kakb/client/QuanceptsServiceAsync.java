package kakb.client;

import java.util.List;

import kakb.shared.quancepts.QuanceptDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface QuanceptsServiceAsync {

	void retrieveQuancepts(AsyncCallback<List<QuanceptDTO>> callback);
	void registerQuancept(QuanceptDTO dto, AsyncCallback<QuanceptDTO> callback);

}
