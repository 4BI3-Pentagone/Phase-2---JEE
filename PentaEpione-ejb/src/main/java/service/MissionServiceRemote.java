package service;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import model.Affectation;
import model.Mission;

@Remote
public interface MissionServiceRemote {

	public void addMission(Mission mission);
	public void removeMission(Mission mission);
	public void updateMission(Mission mission);
	public List<Mission> findListMission();
	public List<Mission> findMissionbyDateAffect(Date date,Affectation affectation);
}
