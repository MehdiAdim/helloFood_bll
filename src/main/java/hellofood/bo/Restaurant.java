package hellofood.bo;

import java.util.HashSet;
import java.util.Set;

public class Restaurant {

	
	private Long idRestaurant;
	
	private String nomRestaurant;
	
	private String adresseRestaurant;
	
	private Set reservations = new HashSet();
	
	private Set tables = new HashSet();
	
	
	
	

	
	
	public Set getTables() {
		return tables;
	}

	public void setTables(Set tables) {
		this.tables = tables;
	}

	public Set getReservations() {
		return reservations;
	}

	public void setReservations(Set reservations) {
		this.reservations = reservations;
	}

	public Long getIdRestaurant() {
		return idRestaurant;
	}

	public void setIdRestaurant(Long idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

	public String getNomRestaurant() {
		return nomRestaurant;
	}

	public void setNomRestaurant(String nomRestaurant) {
		this.nomRestaurant = nomRestaurant;
	}

	public String getAdresseRestaurant() {
		return adresseRestaurant;
	}

	public void setAdresseRestaurant(String adresseRestaurant) {
		this.adresseRestaurant = adresseRestaurant;
	}

}