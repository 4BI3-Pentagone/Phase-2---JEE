package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Flux;

/**
 * Session Bean implementation class FluxService
 */
@Stateless
@LocalBean
public class FluxService implements FluxServiceRemote, FluxServiceLocal {

    @PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public FluxService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addFlux(Flux flux) {
		em.persist(flux);
		
	}

	@Override
	public void removeFlux(Flux flux) {
		em.remove(em.merge(flux));
		
	}

	@Override
	public void updateFlux(Flux flux) {
		em.merge(flux);
		
	}

	@Override
	public List<Flux> findListFlux() {
		return em.createQuery("select f from Flux f",Flux.class).getResultList();
	}

	@Override
	public List<Flux> findListNotAffected() {
		String req="select f from Flux f where f not in (select DISTINCT a.flux from Affectation a where a.flux=f.id)";
		return em.createQuery(req,Flux.class).getResultList();
	}

}
