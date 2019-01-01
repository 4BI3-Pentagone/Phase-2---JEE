package service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import model.Agent;
import model.Site;

@Local
public interface AgentServiceLocal {
	public List<Agent> getAllAgent();
	public void deleteAgentByMatricule(String matricule);
	public void deleteAgentById(int id);
	public void updateAgent(Agent agent);
	public Agent getAgentByMat(String matricule);
	public Agent getAgentById(int id);
	public void addAgent(Agent a);
	public void removeAgent(Agent a);
	public List<Agent> findAgentNotAffected(Date date);
	public boolean AddAgent(Agent agent);
	public List<Agent> findAll();
	public void saveOrUpdate(Agent agent);
	void DeleteAgent(Agent agent);
	public void AjoutAgent(Agent agent);

}
