package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;
import tn.esprit.spring.services.TimesheetServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetServiceImplTest {
	
	@Autowired
	ITimesheetService ts;
	
	@Autowired
	TimesheetRepository repoTime;
	
	@Autowired
	MissionRepository repoMission;
	
	@Autowired
	EmployeRepository repoEmploye;
	
	@Autowired
	IEmployeService serEmploye;
	
	@Autowired 
	IEntrepriseService serEntreprise;
	
	
	
	
	
	private static final Logger l =
			LogManager.getLogger(TimesheetServiceImplTest.class);
	
	
	@Before
    public void setup1() {
       // MockitoAnnotations.initMocks(this);
		repoMission.deleteAll();
        l.info("intialisation done");
    }
	
	@Before
    public void setup2() {
       // MockitoAnnotations.initMocks(this);
		repoEmploye.deleteAll();
        l.info("intialisation done");
    }
	
	@Before
    public void setup3() {
       // MockitoAnnotations.initMocks(this);
		//repoTime.deleteAll();
        l.info("intialisation done");
    }
	
	@After
    public void setdown() {
       // MockitoAnnotations.initMocks(this);
		//repoMission.deleteAll();
        l.info("Final done");
    }
	
	
	
	@Test
	public void testAddMission() {
		
		Mission mission = new Mission( "mymission","it's my mission");
		Mission  result = ts.ajouterMission(mission);
		
		assertEquals("mymission", result.getName());
		assertEquals("it's my mission", result.getDescription());
		
		l.info("Out addMission successfully() without errors.");
		
		
	}
	
	
	@Test
	public void testGetAllMissions(){
		Mission mission1 = new Mission( "mymission 1","it's my mission 1");
		Mission mission2 = new Mission( "mymission 2","it's my mission 2");
		ts.ajouterMission(mission1);
		ts.ajouterMission(mission2);
	
		List<Mission> missions = (List<Mission>) repoMission.findAll();
		assertEquals(2, missions.size());
		int size = missions.size();
		l.info("Done, list size : {}"  , size);
	}
	/*
	
	@Test
	public void testDeleteMission() {
		Mission mission = new Mission( "mymission","it's my mission");
		Mission  result = ts.ajouterMission(mission);
		ts.deleteMission(result);
        assertThat(repoMission.findAll()).isEmpty();;
        l.info("deleted successfully" );
	}
	
	
	
	@Test
	public void testAddTimesheet() throws ParseException {
		try{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateDebut = dateFormat.parse("2015-03-23");
		Date dateFin = dateFormat.parse("2016-03-23");
		
		ts.ajouterTimesheet(4 ,1,dateDebut,dateFin);
		l.info("Out addTimesheet successfully() without errors.");
		}
		catch(Exception e){
			l.error("Erreur dans addMission() : " + e);
			
		}
		
	}
	*/
	
	@Test
	public void testValiderTimesheet() throws ParseException {
		Employe validateur = new Employe("Amir", "El Abed", "amir@gmail.com" , true, Role.CHEF_DEPARTEMENT );
		serEmploye.ajouterEmploye(validateur);
		l.info("Validateur added");
		
		Employe employe = new Employe("Halim", "Kadhi", "halim@gmail.com" , true, Role.INGENIEUR );
		serEmploye.ajouterEmploye(employe);
		l.info("Emplye added");
		
		Departement departement = new Departement("Informatique" );
		serEntreprise.ajouterDepartement(departement);
		l.info("Departement added");
		
		serEmploye.affecterEmployeADepartement(validateur.getId(), departement.getId());
		l.info("E&D affected");
		
		Mission mission = new Mission( "mymission","it's my mission");
		ts.ajouterMission(mission);
		l.info("Mission added");
		
		ts.affecterMissionADepartement(mission.getId(), departement.getId());
		l.info("M&D affected");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateDebut = dateFormat.parse("2015-03-23");
		Date dateFin = dateFormat.parse("2016-03-23");
		
		ts.ajouterTimesheet(mission.getId() ,employe.getId(),dateDebut,dateFin);
		l.info("Out addTimesheet successfully() without errors.");
		
		ts.validerTimesheet(mission.getId(), employe.getId(), dateDebut, dateFin, validateur.getId());
		
		l.info("Valide");
		
	}
	
	/*
	@Test
	public void testAffecterMissionDeppartment() throws ParseException {
		ts.affecterMissionADepartement(19, 1);
	}
	
	*/
	
	/*
	@Test
	public void testGetAllTimesheet() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateDebut = dateFormat.parse("2015-03-23");
		Date dateFin = dateFormat.parse("2016-03-23");
		ts.ajouterTimesheet(19 ,1,dateDebut,dateFin);*/
		
		
		//List<Timesheet> timesheets = (List<Timesheet>) repoTime.findAll();
	//assertThat(timesheets).size().isGreaterThan(0);
	//l.info(repoTime.findAll());
	//}	
	
		

}
