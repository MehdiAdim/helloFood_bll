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

		return l;
		
	}

	@Override
	public List<Reservation> getReservationByUser(Long id) {
		String HqlQuery = "from Reservation  where user = " + id.toString();
		List<Reservation> l = (List<Reservation>) getHibernateTemplate().find(HqlQuery);
		if (l == null || l.size() == 0)
			throw new ObjectRetrievalFailureException(Reservation.class, null);

		return l;
	}

}

