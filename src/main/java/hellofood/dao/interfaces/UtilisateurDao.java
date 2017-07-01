package hellofood.dao.interfaces;

import hellofood.bo.security.Utilisateur;
import com.boudaa.dao.GenericDao;

public interface UtilisateurDao extends GenericDao<Utilisateur, Long> {

	public Utilisateur getUserByLogin(String pString);
	
	public Utilisateur getUserById(Long id);
}
