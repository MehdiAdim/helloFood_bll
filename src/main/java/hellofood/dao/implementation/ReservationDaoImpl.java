package hellofood.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.boudaa.dao.impl.GenericDaoImpl;

import hellofood.bo.Reservation;
import hellofood.dao.interfaces.ReservationDao;

public class ReservationDaoImpl  extends GenericDaoImpl<Reservation, Long>  implements ReservationDao {

	public ReservationDaoImpl() {
		super(Reservation.class);
	}

	public List<Reservation> getReservationByName(String pName) {
	return null;
	}

	@Override
	public List<Reservation> getReservationByTitle(String pTitle) {
	return null;
	}

	@Override
	public List<Reservation> getReservationsByRestaurant(Long idrestaurant) {
		
		String HqlQuery = "from Reservation  where restaurant = " + idrestaurant.toString();
				

		List l = getHibernateTemplate().find(HqlQuery);
		if (l == null || l.size() == 0)
			throw new ObjectRetrievalFailureException(Reservation.class, null);
		System.out.println(" Trouuuuvééé");

		return l;
		
	}

}

