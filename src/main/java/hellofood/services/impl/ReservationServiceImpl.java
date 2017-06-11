package hellofood.services.impl;

import java.util.List;
import java.util.Map;

import com.boudaa.dao.exceptions.EntityNotFoundException;

import hellofood.bo.Reservation;
import hellofood.dao.interfaces.ReservationDao;
import hellofood.services.DateService;
import hellofood.services.ReservationService;

/**
 * 
 *  business logic implementation for Reservation
 *
 */

public class ReservationServiceImpl implements ReservationService {


	//  Dependency injection

	private ReservationDao reservationDao;
	
	private DateService dateService;


	

	public DateService getDateService() {
		return dateService;
	}


	public void setDateService(DateService dateService) {
		this.dateService = dateService;
	}


	public ReservationServiceImpl(){

	}


	public void addNewReservation(Reservation pReservation) {


		reservationDao.create(pReservation);

	}

	public List<Reservation> getAllReservations() {


		return reservationDao.getAll();
	}

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
				
				System.out.println(list.get(i).getEndReservation());
				
			}
			
			
			
			
			
			
		}
		else 
			System.out.println("nulllll");

	}




}






