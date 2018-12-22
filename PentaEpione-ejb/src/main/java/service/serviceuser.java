package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.AspNetUser;

/**
 * Session Bean implementation class serviceuser
 */
@Stateless
@LocalBean
public class serviceuser implements serviceuserRemote, serviceuserLocal {
	@PersistenceContext
   EntityManager em;

    /**
     * Default constructor. 
     */
    public serviceuser() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public AspNetUser login(String log, String mdp) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select e from AspNetUser e where e.userName=:log and e.passwordHash=:mdp");
		q.setParameter("log", log);
		q.setParameter("mdp", mdp);

		return (AspNetUser) q.getSingleResult();
	}

    
}
