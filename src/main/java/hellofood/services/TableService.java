package hellofood.services;

import java.util.List;
import java.util.Map;

import hellofood.bo.Table;

import com.boudaa.dao.exceptions.EntityNotFoundException;

/**
 * 
 *  Service interface for Table
 * 
 * @author mehdi
 *
 */
public interface TableService {

	public void addNewTable(Table pTable);

	public List<Table> getAllTables();

	public Map<String, Number> getTablesStat();

	public List<Table> finTableByTitle(String pTitle);

	public Table finTableById(Long idTable) throws EntityNotFoundException;

	public void updateTable(Table pTable) ;

	

	
}
