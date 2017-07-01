package hellofood.dao.implementation;

import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.boudaa.dao.exceptions.EntityNotFoundException;
import com.boudaa.dao.impl.GenericDaoImpl;

import hellofood.bo.Reservation;
import hellofood.bo.Table;
import hellofood.dao.interfaces.TableDao;


public class TableDaoImpl extends GenericDaoImpl<Table, Long> implements TableDao {

	public TableDaoImpl() {

		super(Table.class);
	}

	@Override
	public Table getTableById(Long id) throws EntityNotFoundException {
		
		return findById(id);
	}

	@Override
	public List<Table> getAllByRestaurant(Long id) {
		String HqlQuery = "from Table  where restaurant = " + id.toString();
		

		List l = getHibernateTemplate().find(HqlQuery);
		if (l == null || l.size() == 0)
			throw new ObjectRetrievalFailureException(Reservation.class, null);

		return l;
	}

	


}
