package service;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import model.Agent;

@Remote
public interface AgentServiceRemote {
	public List<Agent> getAllAgent();
	public void deleteAgentByMatricule(String matricule);
	public void deleteAgentById(int id);
	public void updateAgent(Agent agent);
	public Agent getAgentByMat(String matricule);
	public Agent getAgentById(int id);
	public void addAgent(Agent a);
	public List<Agent> findAgentNotAffected(Date date);
	public boolean AddAgent(Agent agent);
	public List<Agent> findAll();
	public void saveOrUpdate(Agent agent);
	void DeleteAgent(Agent agent);
}
