package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;



@Service
public class DepartementServiceImpl implements IDepartementService{
	@Autowired
	DepartementRepository departementRepository;
	
	@Autowired
	EntrepriseRepository entrepriseRepository;
	
	

	public int ajouterDepartement(Departement dept) {
		departementRepository.save(dept);
		return dept.getId();
	}

	
	public Departement getDepartement(int departemntId) {
		Departement dept = departementRepository.findById(departemntId).get();
		return dept ;
	}
	
	
	public void deleteDepartementById(int departemntId) {
		departementRepository.delete(departementRepository.findById(departemntId).get());	
	}

	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		
				Entreprise entrepriseManagedEntity = entrepriseRepository.findById(entrepriseId).get();
				Departement depManagedEntity = departementRepository.findById(depId).get();
				
				depManagedEntity.setEntreprise(entrepriseManagedEntity);
				departementRepository.save(depManagedEntity);
		
	}


	public List<Departement> getAllDepartement() {
				return (List<Departement>) departementRepository.findAll();
	}

}


