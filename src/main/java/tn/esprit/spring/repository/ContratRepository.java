package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entities.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Integer>{
	@Query("SELECT count(*) FROM Contrat")
    public int countemp();
	
	
	@Query(value="select * from Contrat where u.date_debut between :date1 and :date2",nativeQuery =true) 
	List<Contrat> retrieveParDateJpql(@Param("date1") Date date1, @Param("date2") Date date2);
	
} 
