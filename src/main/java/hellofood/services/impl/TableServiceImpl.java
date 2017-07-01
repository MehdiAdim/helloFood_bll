package hellofood.services.impl;

import java.util.List;
import java.util.Map;

import com.boudaa.dao.exceptions.EntityNotFoundException;

import hellofood.bo.Table;
import hellofood.dao.interfaces.TableDao;
import hellofood.services.TableService;


/**
 * 
 *  business logic implementation for Reservations
 * 
 * 
 *
 */

public class TableServiceImpl implements TableService {

	
	private TableDao tableDao;
	
	

	

	public void addNewTable(Table pTable) {

		tableDao.create(pTable);

	}

	public List<Table> getAllTables() {

		

		return tableDao.getAll();
	}

	

	@Override
	public Table findTableById(Long idTable) throws EntityNotFoundException {
		return tableDao.findById(idTable);

	}
	public void updateTable(Table pTable) {
		tableDao.update(pTable);
		
	}


	public TableDao getTableDao(){
		return tableDao;
	}

	
	public void setTableDao(TableDao TableDao) {
		this.tableDao = TableDao;
	}

	@Override
	public Map<String, Number> getTablesStat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Table> getAllTablesByRestaurant(Long id) {
		
		return tableDao.getAllByRestaurant(id);
	}

	



}
