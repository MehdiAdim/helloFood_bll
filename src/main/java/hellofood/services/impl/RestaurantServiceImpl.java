package hellofood.services.impl;

import java.util.List;

import com.boudaa.dao.exceptions.EntityNotFoundException;

import hellofood.bo.Restaurant;
import hellofood.dao.interfaces.RestaurantDao;
import hellofood.services.RestaurantService;

public class RestaurantServiceImpl implements RestaurantService {

	private RestaurantDao restoDao;

	public void createRestaurant(Restaurant prst) {
		restoDao.create(prst);
	}

	public List<Restaurant> getAllRestaurants() {
		System.out.println("get All call");
		return restoDao.getAll();
	}

	public List<Restaurant> getRestaurantBynom(String pnom) {
		return null;
	}
	
	public Restaurant findRestaurantByID(Long id) throws EntityNotFoundException{
		return restoDao.findById(id);
	}
	


	@Override
	public void deleteRestaurant(Restaurant u) throws EntityNotFoundException {
		restoDao.delete(u.getIdRestaurant());
	}

	public RestaurantDao getRestoDao() {
		return restoDao;
	}

	public void setRestoDao(RestaurantDao restoDao) {
		this.restoDao = restoDao;
	}
	
	

}
