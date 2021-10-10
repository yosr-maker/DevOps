package tn.esprit.spring.services;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;


@Service
public class ContratServiceImpl implements ContratService{

	@Autowired
	ContratRepository contratRepoistory;
	@Autowired
	EmployeRepository empRepoistory;
	
	
	
	@Transactional
	public void deleteContratById(int reference) {
		contratRepoistory.delete(contratRepoistory.findById(reference).get());	
		}
	
	@Override
	public Contrat getContratById(int reference) {
		return contratRepoistory.findById(reference).get();	}
		
		@Override
		public List<Contrat> getAllContrats() {
			return (List<Contrat>) contratRepoistory.findAll();

	}
		@Override
		public List<Contrat> retrieveParDateJpql(Date date1,Date date2)
		{
			List<Contrat>contrats= (List<Contrat>) contratRepoistory.findAll();
			for (Contrat contrat:contrats){
				System.out.print("La liste des contrats:"+contrats);			}
			return contrats;
	


	

		}


		}

	
	

