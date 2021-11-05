package tn.esprit.spring.services;



import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Contrat;

public interface ContratService {

	
	public void deleteContratById(int reference);
	public Contrat getContratById(int reference );
	public List<Contrat> getAllContrats();
	List<Contrat> retrieveParDateJpql(Date date1, Date date2);
}
