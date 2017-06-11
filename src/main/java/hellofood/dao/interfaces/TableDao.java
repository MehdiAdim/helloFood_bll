package hellofood.dao.interfaces;


import java.util.List;

import com.boudaa.dao.GenericDao;

import hellofood.bo.Table;


public interface TableDao extends GenericDao<Table, Long> {

	public List<Table> getTableByTitle(String pTitle);
}
