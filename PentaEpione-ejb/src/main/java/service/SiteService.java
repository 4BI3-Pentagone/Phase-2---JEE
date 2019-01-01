package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Pays;
import model.Site;
import model.Ville;

/**
 * Session Bean implementation class SiteService
 */
@Stateless
@LocalBean
public class SiteService implements SiteServiceRemote, SiteServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public SiteService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Site> getAllSites() {
		return em.createQuery("SELECT s from Site s",Site.class).getResultList();
	}

	@Override
	public void addSite(Site s) {
		em.persist(s);
		
	}

	@Override
	public Site getSiteByID(int id) {
		return em.find(Site.class, id);
	}

	@Override
	public List<Site> getSitesByPays(String pays) {
		return em.createQuery("SELECT s form Site s where s.pays=:pays",Site.class).setParameter("pays", pays).getResultList();
	}

	@Override
	public List<Site> getSitesByVille(String ville) {
	return em.createQuery("SELECT s form Site s where s.ville=:ville",Site.class).setParameter("ville", ville).getResultList();
	}

	@Override
	public void removeSite(Site s) {
		em.remove(em.contains(s) ? s: em.merge(s));
		
	}

	@Override
	public void updateSite(Site s) {
		em.merge(s);
		
	}


	@Override
	public List<Site> getSitesByPays(Pays pays) {
		return em.createQuery("SELECT s FROM Site s WHERE s.ville in (SELECT v FROM Ville v WHERE pays=:pays)",Site.class).setParameter("pays", pays).getResultList();
	}

	@Override
	public List<Site> getSitesByVille(Ville ville) {
		return em.createQuery("SELECT s FROM Site s WHERE s.ville=:ville",Site.class).setParameter("ville", ville).getResultList();
	}

	@Override
	public void addPays(Pays p) {
		em.persist(p);
		
	}

	@Override
	public void updatePays(Pays p) {
		em.merge(p);
		
	}

	@Override
	public void removePays(Pays p) {
		em.remove(em.contains(p) ? p : em.merge(p));
		
	}

	@Override
	public void addVille(Ville v) {
		em.persist(v);
		
	}

	@Override
	public void updateVille(Ville v) {
		em.merge(v);
		
	}

	@Override
	public void removeVille(Ville v) {
		em.remove(em.contains(v) ? v : em.merge(v));
		
	}

	@Override
	public List<Ville> getAllVilles() {
		return em.createQuery("SELECT v FROM Ville v ",Ville.class).getResultList();
	}

	@Override
	public List<Ville> getVillesByPays(Pays pays) {
		return em.createQuery("SELECT v FROM Ville v WHERE pays=:pays",Ville.class).setParameter("pays", pays).getResultList();
	}

	@Override
	public List<Pays> getAllPays() {
		return em.createQuery("SELECT p FROM Pays p",Pays.class).getResultList();
	}

	@Override
	public Pays getPaysByID(int id) {
		return em.find(Pays.class, id);
	}

	@Override
	public Ville getVilleById(int id) {
		return em.find(Ville.class, id);
	}

	

}
