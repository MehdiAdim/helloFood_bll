package hellofood.services;

import java.util.List;
import java.util.Map;

import hellofood.bo.Table;

import com.boudaa.dao.exceptions.EntityNotFoundException;

/**
 * 
 *  Service interface for Table
 * 
 * 
 *
 */
public interface TableService {

	public void addNewTable(Table pTable);

	public List<Table> getAllTables();

	public Map<String, Number> getTablesStat();


	public Table findTableById(Long idTable) throws EntityNotFoundException;

	public void updateTable(Table pTable) ;

	

	
}
