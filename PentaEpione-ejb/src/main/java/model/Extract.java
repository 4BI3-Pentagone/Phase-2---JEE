package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name="Extract")
public class Extract implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdEx")
	private int idEx;
	@Column
private String lastname;
	@Column
private String firstname;
	@Column
private String adresse;
	@Column
private String speciality_s;
	@Column
private String profile ;
	@Column
private String photo;
	@Column
private String telephone;
	@Column
private String password;
	@Column
private String lat ; 
	@Column
private String lng;











public String getLastname() {
	return lastname;
}





public void setLastname(String lastname) {
	this.lastname = lastname;
}





public String getFirstname() {
	return firstname;
}





public void setFirstname(String firstname) {
	this.firstname = firstname;
}





public String getTelephone() {
	return telephone;
}





public String getLat() {
	return lat;
}





public void setLat(String lat) {
	this.lat = lat;
}





public String getLng() {
	return lng;
}





public void setLng(String lng) {
	this.lng = lng;
}





public void setTelephone(String telephone) {
	this.telephone = telephone;
}





public String getPassword() {
	return password;
}





public void setPassword(String password) {
	this.password = password;
}












public Extract() {
	super();
}





public String getSpeciality_s() {
	return speciality_s;
}





public void setSpeciality_s(String speciality_s) {
	this.speciality_s = speciality_s;
}






public String getAdresse() {
	return adresse;
}
	
public void setAdresse(String adresse) {
	this.adresse = adresse;
}








public String getProfile() {
	return profile;
}

public void setProfile(String profile) {
	this.profile = profile;
}





public String getPhoto() {
	return photo;
}





public void setPhoto(String photo) {
	this.photo = photo;
}





@Override
public String toString() {
	return "id= "+idEx +"lastname=" + lastname + ", firstname=" + firstname + ", adresse=" + adresse + ", specialite=" + speciality_s
			+ ", profile=" + profile + ", photo=" + photo +", telephone="+telephone;
}




}
