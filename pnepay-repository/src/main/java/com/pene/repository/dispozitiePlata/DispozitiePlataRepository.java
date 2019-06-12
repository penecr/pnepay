package com.pene.repository.dispozitiePlata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pene.model.entity.DispozitiePlata;


	@Repository
	public interface DispozitiePlataRepository extends JpaRepository<DispozitiePlata,Integer> {
		@Query("select d from DispozitiePlata d order by d.id")
		List<DispozitiePlata>getAllDispozitii();
		
	}

