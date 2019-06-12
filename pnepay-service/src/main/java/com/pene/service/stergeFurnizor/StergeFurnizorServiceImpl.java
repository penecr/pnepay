package com.pene.service.stergeFurnizor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pene.model.entity.Furnizor;
import com.pene.repository.furnizor.FurnizorRepository;

@Service
public class StergeFurnizorServiceImpl implements StergeFurnizorService {

	@Autowired
	private FurnizorRepository furnizorRepository;
	
	
	public void stergeFurnizor(Furnizor furnizor) {
		furnizorRepository.delete(furnizor);
		
	}

}
