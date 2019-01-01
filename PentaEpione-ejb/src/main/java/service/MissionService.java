package service;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Affectation;
import model.Flux;
import model.Mission;

/**
 * Session Bean implementation class MissionService
 */
@Stateless
@LocalBean
public class MissionService implements MissionServiceRemote, MissionServiceLocal {

    @PersistenceContext
	private EntityManager em;
    
    /**
     * Default constructor. 
     */
    public MissionService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addMission(Mission mission) {
		em.persist(mission);
		
	}

	@Override
	public void removeMission(Mission mission) {
		em.remove(em.merge(mission));
		
	}

	@Override
	public void updateMission(Mission mission) {
		em.merge(mission);
		
	}

	@Override
	public List<Mission> findListMission() {
		// TODO Auto-generated method stub
		return em.createQuery("select f from Mission f",Mission.class).getResultList();
	}

	@Override
	public List<Mission> findListMissionByFlux(Flux flux) {
		return em.createQuery("select m from Mission m where flux=:flux",Mission.class).setParameter("flux", flux).getResultList();
	}

	@Override
	public List<Mission> findMissionbyDateAffect(Date date, Affectation affectation) {
		return em.createQuery("select m from Mission m where m.affectation=:affectation AND m.date_mission=:date",Mission.class).setParameter("affectation", affectation).setParameter("date", date).getResultList();
	}
	

}
