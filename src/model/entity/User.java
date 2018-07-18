package model.entity;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class User {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long
	id;
	@Persistent private String email;
	@Persistent private Date birth;
	@Persistent private boolean status;
	@Persistent private Date created;
	@Persistent private boolean gender;
	@Persistent private Long IdRole;
	public User(String email, Date birth, Date created, boolean gender, Long idRole, boolean status) {
		super();
		this.email = email;
		this.birth = birth;
		this.created = created;
		this.gender = gender;
		IdRole = idRole;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Long getIdRole() {
		return IdRole;
	}
	public void setIdRole(Long idRole) {
		IdRole = idRole;
	}
	
}