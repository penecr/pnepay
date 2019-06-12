package com.pene.repository.factura;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pene.model.entity.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {

	@Query("select f from Factura f order by f.id")
	List<Factura>getAllFacturi();
	
	
}
