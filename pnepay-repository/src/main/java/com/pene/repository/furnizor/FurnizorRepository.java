package com.pene.repository.furnizor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.pene.model.entity.Furnizor;

	@Repository
	public interface FurnizorRepository extends JpaRepository<Furnizor,Long> {
		@Query("select f from Furnizor f order by f.id")
		List<Furnizor>getAllFurnizori();
		
	}

