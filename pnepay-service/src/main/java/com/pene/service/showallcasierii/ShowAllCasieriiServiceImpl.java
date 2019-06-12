package com.pene.service.showallcasierii;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pene.model.entity.Casierie;
import com.pene.repository.casierie.CasierieRepository;


@Service
public class ShowAllCasieriiServiceImpl implements ShowAllCasieriiService {

	@Autowired
	private CasierieRepository casierieRepository;

	public List<Casierie> getAllCasierii() {
		
		return casierieRepository.getAllCasierii();
	}

}
