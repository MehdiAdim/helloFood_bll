package hellofood.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.boudaa.dao.exceptions.EntityNotFoundException;

import hellofood.bo.Reservation;
import hellofood.dao.interfaces.ReservationDao;
import hellofood.services.ReservationService;
import hellofood.tools.DateTools;

/**
 * 
 *  business logic implementation for Reservation
 *
 */

public class ReservationServiceImpl implements ReservationService {


	//  Dependency injection

	private ReservationDao reservationDao;
	
	private DateTools dateTools;

	// ----------------------

	
	//  Getters and Setters

	public DateTools getDateTools() {
		return dateTools;
	}


	public void setDateTools(DateTools dateTools) {
		this.dateTools = dateTools;
	}


	public void addNewReservation(Reservation pReservation) {


		reservationDao.create(pReservation);

	}

	public List<Reservation> getAllReservations() {


		return reservationDao.getAll();
	}
	
	// -------------------
	
	// business logic methods implementation

	public List<Reservation> findReservationByTitle(String pTitle) {

		return reservationDao.getReservationByTitle(pTitle);
	}

	@Override
	public Reservation findReservationById(Long idReservation) throws EntityNotFoundException {
		return reservationDao.findById(idReservation);

	}


	public void deleteReservation(Long pId) throws EntityNotFoundException {
		reservationDao.delete(pId);
	}


	public void updateReservation(Reservation pReservation) {
		reservationDao.update(pReservation);

	}


	public ReservationDao getReservationDao() {
		return reservationDao;
	}


	public void setReservationDao(ReservationDao ReservationDao) {
		this.reservationDao = ReservationDao;
	}

	@Override
	public Map<String, Number> getReservationsStat() {
		return null;
	}

	public ReservationServiceImpl(ReservationDao reservationDao) {
		super();
		this.reservationDao = reservationDao;
	}


	@Override
	public List<Reservation> getReservationsByRestaurant(Long idResto) {

		return reservationDao.getReservationsByRestaurant(idResto);
	}


	@Override
	public void updateReservationDate() {
		
		List<Reservation> list=reservationDao.getAll();
		if(list!=null){
			
			for(int i=0;i<list.size();i++){
				
				if(list.get(i).getEndReservation().before(new Date())){
					
					list.get(i).setNotExpired(false);
					
					reservationDao.update(list.get(i));
					System.out.println("mise a jour de la date");
					
				}
				
			}
			
			
			
			
			
			
		}
		else 
			System.out.println("nulllll");

	}




}






