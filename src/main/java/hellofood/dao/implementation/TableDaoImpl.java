package hellofood.dao.implementation;

import java.util.List;

import com.boudaa.dao.impl.GenericDaoImpl;
import hellofood.bo.Table;
import hellofood.dao.interfaces.TableDao;


public class TableDaoImpl extends GenericDaoImpl<Table, Long> implements TableDao {

	public TableDaoImpl() {

		super(Table.class);
	}

	public List getTableByTitle(String pTitle) {

		// Une requete HQL simple pour chercher les livres par titre
		return getHibernateTemplate().find("from Table where title=?", pTitle);

	}


}
