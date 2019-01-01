package service;

import java.util.List;

import javax.ejb.Local;

import model.Flux;

@Local
public interface FluxServiceLocal {
	
	public void addFlux(Flux flux);
	public void removeFlux(Flux flux);
	public void updateFlux(Flux flux);
	public List<Flux> findListFlux();
	public List<Flux> findListNotAffected();
	
}
