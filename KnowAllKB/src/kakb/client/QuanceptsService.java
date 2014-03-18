package kakb.client;

import java.util.List;

import kakb.shared.quancepts.QuanceptDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("quancepts")
public interface QuanceptsService extends RemoteService {
	
	List<QuanceptDTO> retrieveQuancepts();
	QuanceptDTO registerQuancept(QuanceptDTO dto);
	
}
