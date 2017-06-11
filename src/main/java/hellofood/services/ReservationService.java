package hellofood.services;

import java.util.List;
import java.util.Map;
import hellofood.bo.Reservation;
import com.boudaa.dao.exceptions.EntityNotFoundException;

/**
 * 
 *  business logic interface for Reservations
 * 
 * @author mehdi
 *
 */

public interface ReservationService {

	
	public void updateReservationDate();
	
	public List<Reservation> getReservationsByRestaurant(Long idResto); 
	
	public void addNewReservation(Reservation pReservation);

	public List<Reservation> getAllReservations();

	public Map<String, Number> getReservationsStat();

	public List<Reservation> findReservationByTitle(String pTitle);

	public Reservation findReservationById(Long idReservation) throws EntityNotFoundException;

	public void updateReservation(Reservation pReservation) ;

	public void deleteReservation(Long pId) throws EntityNotFoundException;
	
	

	
}
