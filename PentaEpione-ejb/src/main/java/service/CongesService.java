package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Conges;

/**
 * Session Bean implementation class CongesService
 */
@Stateless
@LocalBean
public class CongesService implements CongesServiceRemote, CongesServiceLocal {

	@PersistenceContext
	EntityManager em;
    public CongesService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Conges> findAllConges() {
		return em.createQuery("select c from Conges c",Conges.class).getResultList();
	}

}
