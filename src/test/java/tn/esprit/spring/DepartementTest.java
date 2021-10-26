package tn.esprit.spring;


import static org.junit.Assert.*;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import tn.esprit.spring.entities.Departement;

import tn.esprit.spring.services.IDepartementService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementTest {



@Autowired
IDepartementService deptService;




Logger logger = LoggerFactory.getLogger(DepartementTest.class);



@Test
public void testgetDepartement() {
Departement dept = deptService.getDepartement(1);
assertNotNull(dept.getName());
logger.info("voila le departement demandé : {} ", dept);
}

/*

@Test
public void testajouterDepartement() {
	
Departement dep = new Departement("devops");
deptService.ajouterDepartement(dep);
assertNotNull(dep.getId());
logger.info("l'ajout est effectué avec succés : {} ", dep);

}


*/


//@Test
//public void testaffecterDepartementAEntreprise() {
//	
//	Departement dep = new Departement("devops");
//	Entreprise en = new Entreprise("sagem","rse");
//	deptService.ajouterDepartement(dep);
//	
//	deptService.affecterDepartementAEntreprise(dep.getId(), en.getId());
//	assertNotNull(dep.getEntreprise());
//}
//}




//@Test
//public void testgetAllDepartement() {
//	
//	List<Departement> departements =  deptService.getAllDepartement();
//	//assertEquals(departements.size(), deptService.getAllDepartement().size());
//}





/*
@Test
public void testdeleteDepartementById() {

Departement depa = new Departement();

depa.setName("Programmation"); 
deptService.ajouterDepartement(depa);

assertEquals(depa, deptService.getDepartement(depa.getId()));
logger.info("l'ajout est effectué avec succés : {] " ,depa);
deptService.deleteDepartementById(depa.getId());
assertNull(deptService.getDepartement(depa.getId()));
logger.info("la suppression est effectuée avec succés " ); 

}
*/






}













