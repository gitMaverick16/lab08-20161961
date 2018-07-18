package model.entity;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.util.*;



@PersistenceCapable(identityType = IdentityType.APPLICATION)

public class Listas {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long
	id;
	@Persistent private Date dia;
	@Persistent private String tutor;
	@Persistent private Long IdKids;
	
	@Persistent private Boolean presente;
	
	public Listas(Date dia, String tutor, Long IdKids, Boolean presente) {
		super();
		this.dia = dia;
		this.tutor = tutor;
		this.IdKids=IdKids;
		this.presente=presente;
	}
	public Boolean isPresente(){
		return presente;
	}
	public void setPresente(boolean presente){
		this.presente=presente;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDia(){
		return dia;
	}
	public void setDia(Date dia){
		this.dia=dia;
	}
	public String getTutor(){
		return tutor;
	}
	public void setTutor(String tutor){
		this.tutor=tutor;
	}
	public Long getIdKids(){
		return IdKids;
	}
	public void setIdKids(Long IdKids){
		this.IdKids=IdKids;
	}
}
	