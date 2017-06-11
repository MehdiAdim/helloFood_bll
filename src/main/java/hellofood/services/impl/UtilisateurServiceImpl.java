package hellofood.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.boudaa.dao.exceptions.EntityNotFoundException;

import hellofood.bo.security.Role;
import hellofood.bo.security.Utilisateur;
import hellofood.dao.interfaces.RoleDao;
import hellofood.dao.interfaces.UtilisateurDao;
import hellofood.exceptions.DuplicateLoginException;
import hellofood.services.ReservationService;
import hellofood.services.UtilisateurService;

public class UtilisateurServiceImpl implements UtilisateurService, UserDetailsService {
	
	// DI
	
	private UtilisateurDao userDao;
	private RoleDao roleDao;
	private ReservationService reservationService;
	
	
	
	protected final Log log = LogFactory.getLog(getClass());
	
	

	
	public Utilisateur getPrincipal(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		Utilisateur lUser = null;
		try {
			lUser = userDao.getUserByLogin(userDetails.getUsername());
			
		
			

		} catch (ObjectRetrievalFailureException ex) {
			ex.printStackTrace();
			throw new UsernameNotFoundException("User " + userDetails.getUsername() + " not exists", ex);
			

		}
		
		return lUser;
	}
	
	public UserDetails loadUserByUsername(String pLogin) throws UsernameNotFoundException {
		
		System.out.println("loadUserByUsername");
		
		Utilisateur lUser = null;
		Collection<GrantedAuthority> arrayAuths = new ArrayList<GrantedAuthority>();

		// On récupère un objet de domaine de type User ayant comme login pLogin
		try {
			lUser = userDao.getUserByLogin(pLogin);
			
			reservationService.updateReservationDate();
			

		} catch (ObjectRetrievalFailureException ex) {
			ex.printStackTrace();

			// nous relançons une UsernameNotFoundException si aucun utilisateur
			// ne correspond à cet login
			log.debug("Erreur d'authentification avec le login : " + pLogin);
			System.out.println("not found on database");
			throw new UsernameNotFoundException("User " + pLogin + " not exists", ex);
			

		}
	

		// Si un utilisateur correspond à cet identifiant, nous en profitons
		// pour mettre à jour sa date de dernière connexion
		lUser.setLastAccessDate(Calendar.getInstance().getTime());
		userDao.update(lUser);
		// Il faut ensuite récupérer les rôles de l’utilisateur et les
		// mettre
		// sous la forme de SimpleGrantedAuthority, une interface propre à
		// Spring
		// Security*
		Role role = lUser.getRole();
		System.out.println(role.getRoleName());
		System.out.println(lUser.getPassword());
		arrayAuths.add(new SimpleGrantedAuthority(role.getRoleName()));
		// /un User (classe Spring Security) est créé
		System.out.println("oui");
		return new User(pLogin, lUser.getPassword(), lUser.isEnabled(), lUser.isAccountNotExpired(), true,
				lUser.isAccountNotLocked(), arrayAuths);
	}
	
	
	public Utilisateur getUserByLogin(String pLogin) throws EntityNotFoundException {

		List<Utilisateur> users;
		try {
			users = userDao.getEntityByColumn("Utilisateur", "login", pLogin);

		} catch (ObjectRetrievalFailureException ex) {

			throw new EntityNotFoundException("Aucun utilisateur avec le login : " + pLogin);
		}

		if (users.size() != 1) {
			// TODO : Ecrire le code pour ajouter des log fatal
			// TODO : ecrire le code envoyant un mail d'erreur fatal à
			// l'administrateur

			throw new RuntimeException("Erreur inconnue dans le systeme");
		}

		return users.get(0);
	}
	public void addUtilisateur(Utilisateur user) throws DuplicateLoginException {

		// pour hacher avec SHA1
		ShaPasswordEncoder encoder = new ShaPasswordEncoder();


		// Hachage du mot de passe avec un gain de sel variable = login
		String cryptedPassword = encoder.encodePassword(user.getPassword(),
				user.getLogin());

		// affecter le mot de passe haché
		user.setPassword(cryptedPassword);

		// stockage de l'utilisateur dans la base de données
		try {
			userDao.create(user);

		} catch (DataIntegrityViolationException ex) {
			log.error("erreur d'ajout d'un utilisateur à cause de l'exception " + ex
					+ " . un utilisateur avec le login " + user.getLogin() + " existe déjà dans la base de données");
			throw new DuplicateLoginException("Erreur d'inscription, login existe déjà", ex);
		}

	}

	public Role getRoleByName(String roleName) {
		return roleDao.getRoleByName(roleName);
	}

	public Role getRoleById(Long pRoleId) throws EntityNotFoundException {
		return roleDao.findById(pRoleId);
	}

	public List<Utilisateur> getAllUsers() {
		return userDao.getAll();
	}

	public List<Role> getAllRoles() {
		return roleDao.getAll();
	}

	public void deleteUser(Utilisateur u) throws EntityNotFoundException {

		userDao.delete(u.getIdUtilisateur());

	}

	public UtilisateurDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UtilisateurDao userDao) {
		this.userDao = userDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public ReservationService getReservationService() {
		return reservationService;
	}

	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

    
	


	
	


}
