package service;

import java.util.List;

import javax.ejb.Remote;

import model.Affectation;


@Remote
public interface AffectationServiceRemote {

	public void addAffectation(Affectation affect);
	public void deleteAffectation(Affectation affect);
	public void updateAffectation(Affectation affect);
	public List<Affectation> findListAffectation();
	
}
