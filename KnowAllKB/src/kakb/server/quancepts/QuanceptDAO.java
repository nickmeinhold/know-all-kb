package kakb.server.quancepts;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import kakb.shared.quancepts.QuanceptDTO;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class QuanceptDAO {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	String id;
	@Persistent
	String symbolStr;
	
	private QuanceptDAO() {
		
	}
	
	public QuanceptDAO(QuanceptDTO dto) {
		
		this();
		
		this.setId(dto.getId());
		this.setsymbolStr(dto.getSymbolStr());
		
	}
	
	public QuanceptDTO toDTO() {
		
		QuanceptDTO dto = new QuanceptDTO();
		
		dto.setId(this.getId());
		dto.setSymbolStr(this.getsymbolStr());
		
		return dto;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getsymbolStr() {
		return symbolStr;
	}

	public void setsymbolStr(String symbolStr) {
		this.symbolStr = symbolStr;
	}

}
