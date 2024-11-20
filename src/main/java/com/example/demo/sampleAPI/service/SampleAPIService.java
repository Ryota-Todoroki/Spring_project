package com.example.demo.sampleAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.sampleAPI.data.Animals;
import com.example.demo.sampleAPI.repository.SampleAPIRepository;

@Service
public class SampleAPIService {

	private final SampleAPIRepository sampleAPIRepository;

	public SampleAPIService(SampleAPIRepository sampleAPIRepository) {
		this.sampleAPIRepository = sampleAPIRepository;
	}

	public List<Animals> getAnimals() throws IOException {

		Animals[] animalsList = sampleAPIRepository.getAnimals();

		return Arrays.asList(animalsList);

	}
}
