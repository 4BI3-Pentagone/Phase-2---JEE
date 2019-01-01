package service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import model.User;





/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class UserService implements UserServiceRemote, UserServiceLocal {

	private List <User> lst=new ArrayList<User>();

	@PersistenceContext
	private EntityManager em;
	
		public UserService(){
				
			}
	
	List<User> usersRole;
	private User connected=new User();
	
	

	
	public User authenticate(String nom, String password) {
		User found = null;
		String jpql = "select u from User u where u.nom=:nom and u.password=:password";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("nom", nom);
		query.setParameter("password", password);
		try {
			found = query.getSingleResult();
			setConnected(found);
			                                                     
		} catch (Exception ex) {
			Logger.getLogger(UserService.class.getName()).log(
					Level.WARNING,
					"authentication attempt failure with nom=" + nom
							+ " and password=" + password);
		}
		return found;
	}
	
	
	
	@Override
	public boolean loginExists(String nom) {
		return false;
		/*boolean exists = false;
		String jpql = "select case when (count(u) > 0)  then true else false end from User u where u.nom=:nom";
		TypedQuery<Boolean> query = em.createQuery(jpql, Boolean.class);
		query.setParameter("nom", nom);
		try {
			exists = query.getSingleResult();
		} catch (NoResultException e) {
			Logger.getLogger(UserService.class.getName()).log(
					Level.WARNING, "no user registred with nom=" + nom);
		}
		return exists;*/
	}

	@Override
	public void saveOrUpdate(User user) {
		em.merge(user);	
	}

	public User getConnected() {
		return connected;
	}

	public void setConnected(User connected) {
		this.connected = connected;
	}

	@Override
	public void DeleteUser(User user) {
		em.remove(em.merge(user));

		
	}

	
	
	@Override
	public List<User> findAll() {
		return em.createQuery("select t from User t",User.class ).getResultList();
	}

	@Override
	@Transactional
	public boolean AddUser(User user) {
		em.persist(em.merge(user));
		user = new User();
		return true;
	}

	
	
	



	

	

  
}
