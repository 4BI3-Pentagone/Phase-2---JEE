package service;

import java.util.List;

import javax.ejb.Local;
import model.Contrat;

@Local
public interface ContratServiceLocal {

	public List<Contrat> findAllContrat();
	public void addContrat(Contrat contrat);
	public void deleteContrat(Contrat contrat);
	public void updateContrat(Contrat contrat);
}
