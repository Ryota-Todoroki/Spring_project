package com.example.demo.animalsAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.animalsAPI.data.AnimalData;
import com.example.demo.animalsAPI.service.AnimalService;
import com.example.demo.sampleAPI.data.Animals;

@Controller
public class AnimalController {

	private final AnimalService animalService;
	
	public AnimalController(AnimalService animalService) {
		this.animalService = animalService;
	}

	@GetMapping("/animalAPI")
	public String showSearchPage(Model model) {
		model.addAttribute("message", "");
		return "animal-search";
	}

	@GetMapping("/animalAPI/search")
	public String getPets(@RequestParam(value = "animalType", required = false) String animalType) throws IOException {
		List<Animals> animalsList;
		if (animalType == null || animalType.isEmpty()) {
			animalsList = animalService.getAnimals();
		} else {
			animalsList = animalService.getAnimalsByType(animalType);
		}

		if (!animalsList.isEmpty()) {
			String firstAnimalId = String.valueOf(animalsList.get(0).getId());
			return "redirect:/animalAPI/detail?id=" + firstAnimalId;
		} else {
			return "redirect:/animalAPI";
		}
	}


	@GetMapping("/animalAPI/detail")
	public String getAnimalDetail(@RequestParam("id") String id, Model model) throws IOException {
		AnimalData animal = animalService.getAnimalById(id);
		model.addAttribute("animal", animal);
		return "animal-detail";
	}
}
