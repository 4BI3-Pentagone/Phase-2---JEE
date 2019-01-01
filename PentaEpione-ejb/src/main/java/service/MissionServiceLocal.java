package service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import model.Affectation;
import model.Flux;
import model.Mission;

@Local
public interface MissionServiceLocal {
	
	public void addMission(Mission mission);
	public void removeMission(Mission mission);
	public void updateMission(Mission mission);
	public List<Mission> findListMission();
	public List<Mission> findListMissionByFlux(Flux flux);
	public List<Mission> findMissionbyDateAffect(Date date,Affectation affectation);
}
