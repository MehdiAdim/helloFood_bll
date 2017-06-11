package hellofood.dao.implementation.security;

import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.boudaa.dao.impl.GenericDaoImpl;

import hellofood.bo.security.Utilisateur;
import hellofood.dao.interfaces.UtilisateurDao;

public class UtilisateurDaoImpl extends GenericDaoImpl<Utilisateur, Long> implements UtilisateurDao {

	public UtilisateurDaoImpl() {
		super(Utilisateur.class);
	}

	public Utilisateur getUserByLogin(String pLogin) {
		System.out.println(pLogin+" getUserByLogin daoImpl");

		List users = getHibernateTemplate().find(
				"from Utilisateur where  login = ? ",pLogin);
	
		

		if (users == null || users.size() == 0 || users.size() != 1)
			throw new ObjectRetrievalFailureException(Utilisateur.class, pLogin);

		return (Utilisateur) users.get(0);
	}

}
