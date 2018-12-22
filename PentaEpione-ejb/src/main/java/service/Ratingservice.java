package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Rate;

/**
 * Session Bean implementation class Ratingservice
 */
@Stateless
@LocalBean
public class Ratingservice implements RatingserviceRemote, RatingserviceLocal {
	@PersistenceContext
	   EntityManager em;

    /**
     * Default constructor. 
     */
    public Ratingservice() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addRate(Rate rate) {
		em.persist(rate);
	}
	 
  
}
