package com.pene.service.stergeDispozitiePlata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pene.model.entity.DispozitiePlata;
import com.pene.repository.dispozitiePlata.DispozitiePlataRepository;


@Service
public class StergeDispozitiePlataServiceImpl implements StergeDispozitiePlataService {

	@Autowired
	private DispozitiePlataRepository dispozitiePlataRepository;
	
	
	public void stergeDispozitiePlata(DispozitiePlata dispozitie) {
		dispozitiePlataRepository.delete(dispozitie);
		
	}

}
