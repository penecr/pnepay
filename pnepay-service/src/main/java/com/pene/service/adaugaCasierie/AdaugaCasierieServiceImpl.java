package com.pene.service.adaugaCasierie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pene.model.entity.Casierie;
import com.pene.repository.casierie.CasierieRepository;


@Service
public class AdaugaCasierieServiceImpl implements AdaugaCasierieService {
	
	@Autowired
	private CasierieRepository casierieRepository;
	
	public void saveCasierie(Casierie casierieDAO) {
		
		Casierie casierie =new Casierie();
		casierie.setNumeCasier(casierieDAO.getNumeCasier());
		casierie.setDenumireCasierie(casierieDAO.getDenumireCasierie());
		casierie.setPunctLucru(casierieDAO.getPunctLucru());
		casierie.setValutaCasierie(casierieDAO.getValutaCasierie());
	
		
		casierieRepository.save(casierie);
		
	}



}
