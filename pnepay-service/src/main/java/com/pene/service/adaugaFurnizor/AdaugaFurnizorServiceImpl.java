package com.pene.service.adaugaFurnizor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pene.model.entity.Furnizor;
import com.pene.repository.furnizor.FurnizorRepository;

@Service

public class AdaugaFurnizorServiceImpl implements AdaugaFurnizorService {
	
	@Autowired
	private FurnizorRepository furnizorRepository;
	
	
	public void adaugaFurnizor(Furnizor furnizorDAO) {
		
		Furnizor furnizor=new Furnizor();
		furnizor.setCif(furnizorDAO.getCif());
		furnizor.setDenumireFurnizor(furnizorDAO.getDenumireFurnizor());
		furnizor.setIbanFurnizor(furnizorDAO.getIbanFurnizor());
		furnizor.setTipFurnizor(furnizorDAO.getTipFurnizor());
		furnizor.setBancaFurnizor(furnizorDAO.getBancaFurnizor());
		furnizor.setPersoanaContact(furnizorDAO.getPersoanaContact());
		furnizor.setEmailPersoana(furnizorDAO.getEmailPersoana());
		
		
		furnizorRepository.save(furnizor);
		
	}


}


