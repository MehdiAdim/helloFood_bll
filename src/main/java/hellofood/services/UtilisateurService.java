package hellofood.services;

import java.util.List;
import com.boudaa.dao.exceptions.EntityNotFoundException;
import hellofood.bo.security.Role;
import hellofood.bo.security.Utilisateur;
import hellofood.exceptions.DuplicateLoginException;

/**
 * 
 *  Service interface for Utilisateur
 * 
 * @author mehdi
 *
 */

public interface UtilisateurService {

	public List<Utilisateur> getAllUsers();

	public Utilisateur getUserByLogin(String pLogin) throws EntityNotFoundException;

	public List<Role> getAllRoles();

	public void addUtilisateur(Utilisateur pUser) throws DuplicateLoginException;

	public void deleteUser(Utilisateur u) throws EntityNotFoundException;

	public Role getRoleById(Long pRoleId) throws EntityNotFoundException;

	public Role getRoleByName(String roleName);
	
	public Utilisateur getPrincipal();
	

}
