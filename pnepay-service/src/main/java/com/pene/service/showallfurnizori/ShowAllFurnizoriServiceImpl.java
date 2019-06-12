package com.pene.service.showallfurnizori;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pene.model.entity.Furnizor;
import com.pene.repository.furnizor.FurnizorRepository;

@Service
public class ShowAllFurnizoriServiceImpl implements ShowAllFurnizoriService {

	@Autowired
	private FurnizorRepository furnizorRepository;

	public List<Furnizor> getAllFurnizori() {

		return furnizorRepository.getAllFurnizori();
	}
}
