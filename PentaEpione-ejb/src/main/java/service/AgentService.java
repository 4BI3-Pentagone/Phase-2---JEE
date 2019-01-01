package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Agent;
import model.User;

/**
 * Session Bean implementation class AgentService
 */
@Stateless
@LocalBean
public class AgentService implements AgentServiceRemote, AgentServiceLocal {

    /**
     * Default constructor. 
     */

	@PersistenceContext
	EntityManager em;
    public AgentService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Agent> getAllAgent() {
		return em.createQuery("SELECT a from Agent a",Agent.class).getResultList();
	}

	@Override
	public void deleteAgentByMatricule(String matricule) {
		Agent a = (Agent) em.createQuery("SELECT a FROM Agent a where a.matricule = :matricule")
                .setParameter("matricule", matricule).getSingleResult();
    	em.remove(a);
		
	}

	@Override
	public void deleteAgentById(int id) {
		Agent a= em.find(Agent.class, id);
    	em.remove(a);
		
	}
	

	@Override
	public void updateAgent(Agent agent) {
		
		em.merge(agent);

		
	}

	@Override
	public Agent getAgentByMat(String matricule) {
		Agent a = (Agent) em.createQuery("SELECT a FROM Agent a where a.matricule = :matricule")
                .setParameter("matricule", matricule).getSingleResult();
		return a;
	}

	@Override
	public Agent getAgentById(int id) {
		
		return em.find(Agent.class, id);
	}

	@Override
	public void addAgent(Agent a) {
		em.persist(a);
		
	}

	@Override
	public void removeAgent(Agent a) {
		em.remove(em.contains(a) ? a : em.merge(a));
	}

	@Override
	public List<Agent> findAgentNotAffected(Date date) {
		return em.createQuery("SELECT a from Agent a where a not in(select distinct m.agent from Mission m where a.id=m.agent and m.date_mission=:date)"
				+ "and a not in (select c from Conges c where :date between c.date_debut and c.date_fin)",Agent.class)
				.setParameter("date", date).getResultList();
	}
	@Override
	public boolean AddAgent(Agent agent) {
		em.persist(agent);
		return true;
	}
	@Override
	public List<Agent> findAll() {
		return em.createQuery("select t from Agent t",Agent.class ).getResultList();
		
	}
	@Override
	public void DeleteAgent(Agent agent) {
		em.remove(em.merge(agent));
		
	}
	
	@Override
	public void saveOrUpdate(Agent agent) {
		em.merge(agent);	
		
	}


	@Override
	public void AjoutAgent(Agent agent) {
		em.persist(em.merge(agent));
	
		
	}

}
