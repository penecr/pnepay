package com.pene.service.adaugaDispozitiePlata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pene.model.entity.DispozitiePlata;
import com.pene.repository.dispozitiePlata.DispozitiePlataRepository;


@Service
public class AdaugaDispozitiePlataServiceImpl implements AdaugaDispozitiePlataService {
	
	@Autowired
	private DispozitiePlataRepository dispozitiePlataRepository;
	
	public void saveDispozitie(DispozitiePlata dispozitieDAO) {
		
		DispozitiePlata dispozitie =new DispozitiePlata();
		
		dispozitie.setDataDispozitie(dispozitieDAO.getDataDispozitie());
		dispozitie.setNume(dispozitieDAO.getNume());
		dispozitie.setSerieBuletin(dispozitieDAO.getSerieBuletin());
		dispozitie.setFunctie(dispozitieDAO.getFunctie());
		dispozitie.setScopPlata(dispozitieDAO.getScopPlata());
		dispozitie.setSumaPlatita(dispozitieDAO.getSumaPlatita());
		dispozitie.setValuta(dispozitieDAO.getValuta());
		dispozitie.setCasierie(dispozitieDAO.getCasierie());
	
		
		dispozitiePlataRepository.save(dispozitie);
		
	}



}
