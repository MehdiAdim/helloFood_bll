package hellofood.dao.implementation;

import java.util.List;

import com.boudaa.dao.exceptions.EntityNotFoundException;
import com.boudaa.dao.impl.GenericDaoImpl;
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

	


}
