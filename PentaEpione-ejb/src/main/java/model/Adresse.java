package model;

public class Adresse {

	public Adresse() {
		// TODO Auto-generated constructor stub
	}
	String city;
	String admin;
	String country;
	String population_proper;
	String iso2;
	String capital;
	
	String lat;
	String lng;
	String population;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	
	
	public String getPopulation_proper() {
		return population_proper;
	}
	public void setPopulation_proper(String population_proper) {
		this.population_proper = population_proper;
	}
	public String getIso2() {
		return iso2;
	}
	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	@Override
	public String toString() {
		return "Adresse [city=" + city + "] ";
				
	}
	
	

}
