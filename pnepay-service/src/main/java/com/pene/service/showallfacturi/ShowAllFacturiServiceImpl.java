package com.pene.service.showallfacturi;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pene.model.entity.Factura;
import com.pene.model.entity.facturaDTO;
import com.pene.repository.factura.FacturaRepository;

@Service
public class ShowAllFacturiServiceImpl implements ShowAllFacturiService {

	@Autowired
	private FacturaRepository facturaRepository;


	public List<facturaDTO> getAllFacturi() {
		
		List<facturaDTO> lista= facturaRepository.getAllFacturi().stream().map(factura->{
			return new facturaDTO(factura.getDataEmiterii(),factura.getDataScadenta(),factura.getTotalFactura(),factura.getDescriereFactura(),factura.getFurnizor().getDenumireFurnizor());
		}).collect(Collectors.toList());
	
	return lista;
	
	}
	

}
