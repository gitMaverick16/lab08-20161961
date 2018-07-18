package model.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Access {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long
	id;
	@Persistent private Long IdRole;
	@Persistent private Long IdUrl;
	@Persistent private boolean status;
	public Access(Long idRole, Long idUrl, Boolean status) {
		super();
		IdRole = idRole;
		IdUrl = idUrl;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdRole() {
		return IdRole;
	}
	public void setIdRole(Long idRole) {
		IdRole = idRole;
	}
	public Long getIdUrl() {
		return IdUrl;
	}
	public void setIdUrl(Long idUrl) {
		IdUrl = idUrl;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}