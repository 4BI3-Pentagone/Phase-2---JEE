package service;

import javax.ejb.Local;

import model.Agent;
import model.Statistiques;

@Local
public interface StatistiquesServiceLocal {
	
	public Statistiques findStat(Agent agent);
	public void addStat(Statistiques stat);
	public void updateStat(Statistiques stat);
	public void removeStat(Statistiques stat);
	
}
