package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;

public interface IDepartementService {
	
	
	
	
	public int ajouterDepartement(Departement dept) ;
	public void affecterDepartementAEntreprise(int depId, int entrepriseId);
		

	
	public Departement getDepartement(int departemntId) ;
		
	
	public void deleteDepartementById(int departemntId) ;



	public List<Departement> getAllDepartement() ;


}
