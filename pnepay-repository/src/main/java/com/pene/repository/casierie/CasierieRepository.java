package com.pene.repository.casierie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pene.model.entity.Casierie;


	@Repository
	public interface CasierieRepository extends JpaRepository<Casierie,Integer> {
		@Query("select c from Casierie c order by c.idCasierie")
		List<Casierie>getAllCasierii();
		
	}

