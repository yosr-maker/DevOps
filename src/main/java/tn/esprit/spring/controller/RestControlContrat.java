package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.ContratService;
import tn.esprit.spring.services.IEmployeService;


@RestController
public class RestControlContrat {

	@Autowired
	ContratService icontratservice;
	@Autowired 
	IEmployeService iemployeservice;
	

	// http://localhost:8081/SpringMVC/servlet/ajouterContrat
	//{"reference":6,"dateDebut":"2020-03-01","salaire":2000,"typeContrat":"CDD"}
	@PostMapping("/ajouterContrat")
	@ResponseBody
	public int ajouterContrat(@RequestBody Contrat contrat) {
		iemployeservice.ajouterContrat(contrat);
		return contrat.getReference();
	}
	
	// http://localhost:8081/SpringMVC/servlet/affecterContratAEmploye/6/1
   @PutMapping(value = "/affecterContratAEmploye/{idcontrat}/{idemp}") 
	public void affecterContratAEmploye(@PathVariable("idcontrat")int contratId, @PathVariable("idemp")int employeId)
	{
		iemployeservice.affecterContratAEmploye(contratId, employeId);
	}

	 // URL : http://localhost:8084/SpringMVC/servlet/getAllContrats
	@GetMapping(value = "/getAllContrats")
	@ResponseBody
	public List<Contrat> getAllContrats() {
		
		return icontratservice.getAllContrats();
	}

	
	   @DeleteMapping("/deleteContratById/{reference}") 
		@ResponseBody 
		public void deleteContratById(@PathVariable("reference")int reference)
		{
		   icontratservice.deleteContratById(reference);
		}
	   
	   @GetMapping(value = "getContratById/{reference}")
	    @ResponseBody
		public Contrat getContratById(@PathVariable("reference") int reference) {

			return icontratservice.getContratById(reference);
		} 
	   
	   
}
