package hellofood.dao.interfaces;

import hellofood.bo.security.Role;
import com.boudaa.dao.GenericDao;

public interface RoleDao extends GenericDao<Role, Long> {
	public Role getRoleByName(String pRole);
}
