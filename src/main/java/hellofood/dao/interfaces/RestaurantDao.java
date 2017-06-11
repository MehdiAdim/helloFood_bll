package hellofood.dao.interfaces;

import java.util.List;


import com.boudaa.dao.GenericDao;

import hellofood.bo.Restaurant;

public interface RestaurantDao extends GenericDao<Restaurant, Long> {

	public List<Restaurant> getRestaurantBynom(String pnom);
	

}
