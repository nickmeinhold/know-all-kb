package kakb.client.main;

import java.util.List;
import java.util.Map;

import kakb.shared.quancepts.QuanceptDTO;

import com.google.gwt.user.client.ui.MultiWordSuggestOracle;

public class MainModel {
	
	Map<String, String> quanceptsMap;
	MultiWordSuggestOracle quanceptsOracle;
	
	public MainModel(Map<String, String> quanceptsMap0, MultiWordSuggestOracle quanceptsOracle0) {
		quanceptsMap = quanceptsMap0;
		quanceptsOracle = quanceptsOracle0;
	}
	
	public void loadModel(List<QuanceptDTO> quancepts) {
		for(QuanceptDTO dto : quancepts) {
			quanceptsOracle.add(dto.getSymbolStr());
			quanceptsMap.put(dto.getSymbolStr(), dto.getId());
		}
	}
	
	public void addToModel(QuanceptDTO dto) {
		quanceptsOracle.add(dto.getSymbolStr());
		quanceptsMap.put(dto.getSymbolStr(), dto.getId());
	}

}
