package tn.esprit.epione.persistance;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType
public class Extract implements Serializable{

private String lastname;
private String firstname;

private Adresse adresse;
private String speciality_s;
private String profile ;
private String photo;
private String telephone;
private String password;
private String lat ; 
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





@XmlAttribute
public Adresse getAdresse() {
	return adresse;
}
	
public void setAdresse(Adresse adresse) {
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
	return "lastname=" + lastname + ", firstname=" + firstname + ", adresse=" + adresse + ", specialite=" + speciality_s
			+ ", profile=" + profile + ", photo=" + photo +", telephone="+telephone;
}

}
