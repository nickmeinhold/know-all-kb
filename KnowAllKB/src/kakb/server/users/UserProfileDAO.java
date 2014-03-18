package kakb.server.users;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import kakb.shared.users.UserProfileDTO;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class UserProfileDAO {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	String id;
	@Persistent
	String googleId;
	@Persistent
	String firstName;
	@Persistent
	String lastName;
	
	private UserProfileDAO() {
		
	}
	
	public UserProfileDAO(String firstName, String lastName) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public UserProfileDAO(UserProfileDTO userProfileDTO) {
		this.setId(userProfileDTO.getId());
		this.setFirstName(userProfileDTO.getFirstName());
		this.setLastName(userProfileDTO.getLastName());
	}
	
	public UserProfileDTO toDTO() {
		
		UserProfileDTO dto = new UserProfileDTO();
		
		dto.setId(this.getId());
		dto.setFirstName(this.getFirstName());
		dto.setLastName(this.getLastName());
		
		return dto;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
