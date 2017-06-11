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
 * @author mehdi
 *
 */

public class TableServiceImpl implements TableService {

	/**
	 * d�pendance avec le DAO g�rant les livres. Spring injetera une instance de
	 * TableDaoImpl dans cette variable
	 */
	private TableDao tableDao;
	
	/**
	 * d�pendance avec le DAO g�rant les rayons. Spring injetera une instance de
	 * RayonDaoImpl dans cette variable
	 */

	

	public void addNewTable(Table pTable) {

		tableDao.create(pTable);

	}

	public List<Table> getAllTables() {

		

		return tableDao.getAll();
	}

	public List<Table> finTableByTitle(String pTitle) {

		// TODO : dans le cas g�n�ral cette m�thode pourra faire des
		// v�rifications des r�gles m�tier avant de passer la main au DAO

		return tableDao.getTableByTitle(pTitle);
	}

	@Override
	public Table finTableById(Long idTable) throws EntityNotFoundException {
		return tableDao.findById(idTable);

	}
	public void updateTable(Table pTable) {
		tableDao.update(pTable);
		
	}


	public TableDao getTableDao() {
		return tableDao;
	}

	// Les getters/setters (necessaires pour que Spring puisse ingecter les
	// d�pendances
	public void setTableDao(TableDao TableDao) {
		this.tableDao = TableDao;
	}

	@Override
	public Map<String, Number> getTablesStat() {
		// TODO Auto-generated method stub
		return null;
	}



}
