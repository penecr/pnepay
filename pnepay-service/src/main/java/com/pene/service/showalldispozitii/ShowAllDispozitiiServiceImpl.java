package com.pene.service.showalldispozitii;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pene.model.entity.DispozitiePlata;
import com.pene.repository.dispozitiePlata.DispozitiePlataRepository;


@Service
public class ShowAllDispozitiiServiceImpl implements ShowAllDispozitiiService {

	@Autowired
	private DispozitiePlataRepository dispozitiePlataRepository;

	public List<DispozitiePlata> getAllDispozitii() {
		
		return dispozitiePlataRepository.getAllDispozitii();
	}

}
