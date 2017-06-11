package hellofood.bo;

import java.util.Set;

public class Table {
	
	private long idTable;
	
	private long numTable;
	
	private int capacite;
	
	private boolean isOccupied=false;
	
	private Restaurant restaurant;
	
	
	
	
	
	
	
	
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	public boolean getIsOccupied(){
		return isOccupied;
	}
	public void setIsOccupied(boolean b){
		this.isOccupied=b;
	}

	
	public long getIdTable() {
		return idTable;
	}

	public void setIdTable(long idTable) {
		this.idTable = idTable;
	}

	public long getNumTable() {
		return numTable;
	}

	public void setNumTable(long numTable) {
		this.numTable = numTable;
	}

	

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}


	
	
	
	
	

}
