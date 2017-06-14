package hellofood.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.boudaa.dao.exceptions.EntityNotFoundException;

import hellofood.bo.Reservation;
import hellofood.bo.Table;
import hellofood.dao.interfaces.ReservationDao;
import hellofood.dao.interfaces.TableDao;
import hellofood.services.ReservationService;
import hellofood.tools.DateTools;
import hellofood.tools.LoggerTools;

/**
 * 
 *  business logic implementation for Reservation
 *
 */

public class ReservationServiceImpl implements ReservationService {


	//  Dependency injection

	private ReservationDao reservationDao;
	
	private DateTools dateTools;
	
	private LoggerTools loggerTools;
	
	private TableDao tableDao;
	
	// -----------------------
	
	protected final Log log = LogFactory.getLog(getClass());

	// ----------------------
	
	
	
	//  Getters and Setters

	
	
	public DateTools getDateTools() {
		return dateTools;
	}


	public TableDao getTableDao() {
		return tableDao;
	}


	public void setTableDao(TableDao tableDao) {
		this.tableDao = tableDao;
	}


	public LoggerTools getLoggerTools() {
		return loggerTools;
	}


	public void setLoggerTools(LoggerTools loggerTools) {
		this.loggerTools = loggerTools;
	}


	public Log getLog() {
		return log;
	}


	public ReservationServiceImpl() {
		super();
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
		
		
		// UPDATE RESERVATION
		
		List<Reservation> list=reservationDao.getAll();
		List<Table> occupiedTables = new ArrayList<Table>();
		
		if(list!=null){
			
			for(int i=0;i<list.size();i++){
				
				if(list.get(i).getEndReservation().before(new Date())){
					
					list.get(i).setNotExpired(false);
					
					reservationDao.update(list.get(i));
					
				}
				else if(dateTools.isBetween(new Date(), list.get(i).getStartReservation(), list.get(i).getEndReservation()))
				{
					try {
						occupiedTables.add(tableDao.findById(list.get(i).getTable().getIdTable()));
						
					} catch (EntityNotFoundException e) {
					}
				}
			}
			loggerTools.addBox(log, "UPDATE RESERVATIONS");
			
		}
		
		
		// UPDATE OCCUPIED TABLES 
		
		if(occupiedTables!=null){
		for(Table t : occupiedTables){
			
			t.setIsOccupied(true);
			tableDao.update(t);
			
			
		}
		}
		
		List<Table> alltables= tableDao.getAll();
		
		
		// Update free tables
		
		for(Table t: alltables){
			int i=0;
			if(t.getIsOccupied()){
				
				for(Reservation r : list){
						
						if(dateTools.isBetween(new Date(), r.getStartReservation(), r.getEndReservation())){
							
							if(r.getTable().getIdTable()==t.getIdTable()){
								
								i++;
							}
						}
						
						
					}
				if(i==0){
					t.setIsOccupied(false);
					tableDao.update(t);
				}
				}
				
			}
		
		loggerTools.addBox(log, "UPDATE TABLES");
		}


	@Override
	public List<Reservation> getReservationsByUser(Long id) {
		return reservationDao.getReservationByUser(id);
	}
		
		

	}











