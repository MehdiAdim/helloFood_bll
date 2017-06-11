package hellofood.dao.interfaces;

import java.util.List;


import com.boudaa.dao.GenericDao;

import hellofood.bo.Reservation;

public interface ReservationDao extends GenericDao<Reservation, Long> {


	public List<Reservation> getReservationByTitle(String pTitle);
	
	public List<Reservation> getReservationsByRestaurant(Long idrestaurant);
	
}
