package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Contrat;

/**
 * Session Bean implementation class ContratService
 */
@Stateless
@LocalBean
public class ContratService implements ContratServiceRemote, ContratServiceLocal {

	@PersistenceContext
	EntityManager em;
	
    public ContratService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Contrat> findAllContrat() {
		return em.createQuery("select c from Contrat c",Contrat.class).getResultList();
	}

	@Override
	public void addContrat(Contrat contrat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteContrat(Contrat contrat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateContrat(Contrat contrat) {
		// TODO Auto-generated method stub
		
	}

}
