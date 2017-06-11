package hellofood.services;

import java.util.List;
import hellofood.bo.Restaurant;
import com.boudaa.dao.exceptions.EntityNotFoundException;

/**
 * 
 *  Service interface for Restaurant
 * 
 * @author mehdi
 *
 */

public interface RestaurantService {
	
	
	public void createRestaurant(Restaurant pRST);
	
	public List<Restaurant> getAllRestaurants();
	
	public List<Restaurant> getRestaurantBynom(String pnom);
	
	public Restaurant findRestaurantByID(Long id)throws EntityNotFoundException;

	public void deleteRestaurant(Restaurant u) throws EntityNotFoundException;

}
