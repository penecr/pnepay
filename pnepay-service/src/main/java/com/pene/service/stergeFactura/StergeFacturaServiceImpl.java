package com.pene.service.stergeFactura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pene.model.entity.Factura;
import com.pene.repository.factura.FacturaRepository;

@Service
public class StergeFacturaServiceImpl implements StergeFacturaService {

	@Autowired
	private FacturaRepository facturaRepository;
	
	
	public void stergeFactura(Factura factura) {
		facturaRepository.delete(factura);
		
	}

}
