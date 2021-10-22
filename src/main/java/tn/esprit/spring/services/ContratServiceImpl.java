package tn.esprit.spring.services;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
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
	
	
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(ContratServiceImpl.class);
	
	
	@Transactional
	public void deleteContratById(int contratId) {
		Optional<Contrat> value = contratRepoistory.findById(contratId);

		if (value.isPresent()) {
			Contrat contratManagedEntity = value.get() ;
		contratRepoistory.delete(contratManagedEntity);

	}
	}
	@Override
	public Contrat getContratById(int reference) {
		int startTime=(int)System.currentTimeMillis();
	
		contratRepoistory.findById(reference);
		
		int endTime=(int)System.currentTimeMillis();
		if((endTime-startTime >3)){
			l.info("be ware");
			
		}
		return null;
		
	}
		
		@Override
		public List<Contrat> getAllContrats() {
			return contratRepoistory.findAll();

	}
		@Override
		public List<Contrat> retrieveParDateJpql(Date date1,Date date2)
		{
			List<Contrat>contrats= contratRepoistory.findAll();
			for (Contrat contrat:contrats){
				l.debug("liste contrats: " , contrats);		}
			return contrats;
	

	

		}


		}

	
	

