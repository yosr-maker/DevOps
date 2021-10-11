package tn.esprit.spring;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
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


private static final Logger l =LogManager.getLogger(DepartementTest.class);



@Test
public void testgetDepartement() {
Departement dept = deptService.getDepartement(1);
assertNotNull(dept.getName());
l.info("getDepartement : "+ dept);
}




@Test
public void testajouterDepartement() {
	
Departement dept = new Departement("devops");
deptService.ajouterDepartement(dept);
assertNotNull(dept.getId());

}




@Test
public void testdeleteDepartementById() {
	
	deptService.deleteDepartementById(6);
	
	assertNull(deptService.getDepartement(5).getName());
	
	
}



@Test
public void testgetAllDepartement() {
	deptService.getAllDepartement();
}

}













