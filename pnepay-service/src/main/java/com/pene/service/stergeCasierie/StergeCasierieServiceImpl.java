package com.pene.service.stergeCasierie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pene.model.entity.Casierie;
import com.pene.repository.casierie.CasierieRepository;


@Service
public class StergeCasierieServiceImpl implements StergeCasierieService {

	@Autowired
	private CasierieRepository casierieRepository;
	
	
	public void stergeCasierie(Casierie casierie) {
		casierieRepository.delete(casierie);
		
	}

}
