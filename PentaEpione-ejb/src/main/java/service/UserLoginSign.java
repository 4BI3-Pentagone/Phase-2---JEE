package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import emel.Util;
import model.AspNetUser;

/**
 * Session Bean implementation class UserLoginSign
 */
@Stateless
@LocalBean
public class UserLoginSign implements UserLoginSignRemote, UserLoginSignLocal {

    /**
     * Default constructor. 
     */
	Util ut = new Util();
	@PersistenceContext
	EntityManager entitymanager;
    public UserLoginSign() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public AspNetUser login(String log, String mdp) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Query q = entitymanager.createQuery("select e from AspNetUser e where e.email=:log and e.passwordHash=:mdp");
		q.setParameter("log", log);
		//String m=ut.getSaltString(mdp);
		System.out.println("logggg");
		q.setParameter("mdp", mdp);

		return (AspNetUser) q.getSingleResult();
	}

	@Override
	public void addUser(AspNetUser U) {
		// TODO Auto-generated method stub
		entitymanager.persist(U);

	}

}
