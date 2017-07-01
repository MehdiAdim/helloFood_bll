package hellofood.dao.interfaces;


import java.util.List;

import com.boudaa.dao.GenericDao;
import com.boudaa.dao.exceptions.EntityNotFoundException;

import hellofood.bo.Table;


public interface TableDao extends GenericDao<Table, Long> {


	
	public Table getTableById(Long id) throws EntityNotFoundException;
	
	public List<Table> getAll();
	
	public List<Table> getAllByRestaurant(Long id);
	
}
