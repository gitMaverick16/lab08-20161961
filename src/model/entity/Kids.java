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



@PersistenceCapable(identityType = IdentityType.APPLICATION)

public class Kids {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long
	id;
	@Persistent private String name;
	@Persistent private String tutor;
	@Persistent private String DNI;
	@Persistent private String place_birth;
	@Persistent private String correo;
	@Persistent private String padre;
	@Persistent private String madre;
	@Persistent private String religion;
	@Persistent private String hobby;
	@Persistent private String grado;
	
	@Persistent private Date created;
	@Persistent private Date birth;
	@Persistent private boolean gender;
	@Persistent private int age;
	
	public Kids(String name, String tutor,String dNI,Date created, boolean gender,String place_birth,Date birth,
			String correo, String padre, String madre, String religion,String hobby, String grado) {
		super();
		this.name = name;
		this.tutor = tutor;
		this.gender = gender;
		this.birth = birth;
		DNI = dNI;
		this.place_birth = place_birth;
		this.created = new Date();
		this.correo = correo;
		this.padre = padre;
		this.madre = madre;
		this.religion = religion;
		this.hobby = hobby;
		this.grado=grado;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTutor() {
		return tutor;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
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
	public String getPlace_birth() {
		return place_birth;
	}
	public void setPlace_birth(String place_birth) {
		this.place_birth = place_birth;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPadre() {
		return padre;
	}
	public void setPadre(String padre) {
		this.padre = padre;
	}
	public String getMadre() {
		return madre;
	}
	public void setMadre(String madre) {
		this.madre = madre;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getGrado(){
		return grado;
	}
	public void setGrado(String grado){
		this.grado=grado;
	}
}
	