package hellofood.dao.implementation;

import java.util.List;
import com.boudaa.dao.impl.GenericDaoImpl;

import hellofood.bo.Restaurant;
import hellofood.dao.interfaces.RestaurantDao;

public class RestaurantDaoImpl  extends GenericDaoImpl<Restaurant, Long>  implements RestaurantDao {

	public RestaurantDaoImpl() {
		super(Restaurant.class);
	}

	public List<Restaurant> getRestaurantBynom(String pnom) {
		return getEntityByColumn("Restaurant", "nom", pnom);
	}

}
