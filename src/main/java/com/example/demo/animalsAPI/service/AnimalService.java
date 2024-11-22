package com.example.demo.animalsAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.animalsAPI.data.AnimalData;
import com.example.demo.animalsAPI.repository.AnimalRepository;
import com.example.demo.sampleAPI.data.Animals;

@Service
public class AnimalService {

	private final AnimalRepository animalRepository;

	public AnimalService(AnimalRepository animalRepository) {
		this.animalRepository = animalRepository;
	}

	public List<Animals> getAnimals() throws IOException {
		Animals[] animalsList = animalRepository.getAnimals();
		return Arrays.asList(animalsList);
	}

	public List<Animals> getAnimalsByType(String type) throws IOException {
		Animals[] animalsList = animalRepository.getAnimals();
		List<Animals> filteredAnimals = Arrays.stream(animalsList)
				.filter(animal -> animal.getName().equalsIgnoreCase(type))
				.collect(Collectors.toList());

		return filteredAnimals;
	}

	public AnimalData getAnimalById(String id) throws IOException {
		Animals[] animalsList = animalRepository.getAnimals();
		Optional<Animals> optionalAnimal = Arrays.stream(animalsList)
				.filter(animal -> String.valueOf(animal.getId()).equals(id))
				.findFirst();

		if (optionalAnimal.isPresent()) {
			Animals animal = optionalAnimal.get();
			AnimalData animalData = new AnimalData();
			animalData.setId(animal.getId());
			animalData.setName(animal.getName());
			animalData.setJapaneseName(animal.getJapaneseName());
			animalData.setCry(animal.getCry());
			return animalData;
		} else {
			return null;
		}
	}
}
