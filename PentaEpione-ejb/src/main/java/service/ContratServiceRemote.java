package service;

import java.util.List;

import javax.ejb.Remote;

import model.Contrat;

@Remote
public interface ContratServiceRemote {

	public List<Contrat> findAllContrat();
	public void addContrat(Contrat contrat);
	public void deleteContrat(Contrat contrat);
	public void updateContrat(Contrat contrat);
}
