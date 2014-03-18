package kakb.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;

import kakb.client.QuanceptsService;
import kakb.server.quancepts.QuanceptDAO;
import kakb.shared.quancepts.QuanceptDTO;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class QuanceptsServiceImpl extends RemoteServiceServlet implements QuanceptsService {

	@Override
	public List<QuanceptDTO> retrieveQuancepts() {
		
		PersistenceManager pm = PMF.get().getPersistenceManager(); 
		List<QuanceptDTO> dtos = new ArrayList<QuanceptDTO>();
		
		Extent<QuanceptDAO> extent = pm.getExtent(QuanceptDAO.class, false);
		for(QuanceptDAO dao : extent) {
			dtos.add(dao.toDTO());
		}
		extent.closeAll();
		pm.close();
		
		return dtos;
	}

	@Override
	public QuanceptDTO registerQuancept(QuanceptDTO dto) {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		QuanceptDAO dao = new QuanceptDAO(dto);
		pm.makePersistent(dao);
		pm.close();
		
		return dao.toDTO();
		
	}

	
		
	
	
}
