package hellofood.dao.implementation.security;

import java.util.List;
import com.boudaa.dao.impl.GenericDaoImpl;
import hellofood.bo.security.Role;
import hellofood.dao.interfaces.RoleDao;

public class RoleDaoImpl extends GenericDaoImpl<Role, Long> implements RoleDao {

	public RoleDaoImpl() {
		super(Role.class);
	}

	public Role getRoleByName(String pRole) {
		
		List<Role> roles = getEntityByColumn("Role", "roleName", pRole);
		return roles.get(0);
	}

}
