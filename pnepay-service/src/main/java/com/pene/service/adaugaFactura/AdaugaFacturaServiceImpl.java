package com.pene.service.adaugaFactura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pene.model.entity.Factura;
import com.pene.repository.factura.FacturaRepository;

@Service
public class AdaugaFacturaServiceImpl implements AdaugaFacturaService {
	
	@Autowired
	private FacturaRepository facturaRepository;
	

	public void saveFactura(Factura facturaDAO) {
		
		Factura factura=new Factura();
		factura.setDataEmiterii(facturaDAO.getDataEmiterii());
		factura.setDataScadenta(facturaDAO.getDataScadenta());
		factura.setTotalFactura(facturaDAO.getTotalFactura());
		factura.setDescriereFactura(facturaDAO.getDescriereFactura());
		factura.setFurnizor(facturaDAO.getFurnizor());
		
		facturaRepository.save(factura);
		
	}

}
