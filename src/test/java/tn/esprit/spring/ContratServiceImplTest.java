	

package tn.esprit.spring;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.ContratService;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceImplTest {

	//private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(ContratServiceImplTest.class);
	
	@Autowired
	ContratService cs;
	@Autowired 
	IEmployeService iemployeservice;
	@Autowired 
	ContratRepository contratRepository;
	@Autowired
	EmployeRepository employeRepository;
	

	@Test(timeout =2000)
	public void testgetContratById() {
	Contrat contrat = cs.getContratById(1);
	assertNotNull(contrat.getTypeContrat());
	//l.info("le contrat est :"+ contrat);

	}
	
	@Test(timeout =2000)
	public void testgetAllContrats() {
		List<Contrat> contrats = (List<Contrat>) contratRepository.findAll();
		assertThat(contrats).size().isGreaterThan(0);
	//	l.info("la liste des contrats est :"+ contrats);
	}


	@Test(timeout =2000)
	public void testajouterContrat() throws ParseException , java.text.ParseException{
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = dateFormat.parse("2021-06-09");
	Contrat u = new Contrat(4, date,"CDD",200);
	iemployeservice.ajouterContrat(u);
	//l.info("ajout avec succés de contrat: " + u.getReference());
	}

	
	@Test(timeout =3000)
	public void testretrieveParDateJpql() throws ParseException, java.text.ParseException {
	SimpleDateFormat date= new SimpleDateFormat("yyyy-MM-dd");
	Date date1= date.parse("2020-01-01");
	Date date2= date.parse("2021-12-30");
	cs.retrieveParDateJpql(date1,date2);
	//l.info("test retrieveParDateJpql avec succes");
	}
	


	@Test(timeout = 2000)
	public void testDeleteContrat() {
		
		  Contrat c = new Contrat();
		  c.setDateDebut(new Date()); 
		  c.setSalaire(3000); 
		  c.setTypeContrat("CDI"); 
		  
		  c.setReference(iemployeservice.ajouterContrat(c)); 
		  
		  assertEquals(c, cs.getContratById(c.getReference()));
		 // l.info("ajout avec succés de contrat: " + c.getReference());
		  cs.deleteContratById(c.getReference());
		 // l.info("delete contrat: " + c.getReference());  
		  assertNull(cs.getContratById(c.getReference()));
		 // l.info("test delete success");
	}
	


	
	
}

