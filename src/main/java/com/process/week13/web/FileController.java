package com.process.week13.web;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.process.week13.Recipe;
import com.process.week13.service.FileService;


@RestController
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@GetMapping("/all-recipes")
	public List<Recipe> readLines() throws IOException {
		return fileService.readFile("recipes.txt");
	}
	
	@GetMapping("/checking")
	public String testing() {
		return "Will I get there? ";
	}
	
	@GetMapping("/gluten-free")
	public List<Recipe> getGlutenFree () throws IOException {
		Predicate<Recipe> glutenFree = gf -> gf.getGlutenFree().booleanValue() == true;
		
		return (List<Recipe>) fileService.readFile("recipes.txt").stream().filter(glutenFree).collect(Collectors.toList());
	}
	
	@GetMapping("/vegan")
	public List<Recipe> getVegan () throws IOException {
		Predicate<Recipe> vegan = v -> v.getVegan().booleanValue() == true;
		
		return (List<Recipe>) fileService.readFile("recipes.txt").stream().filter(vegan).collect(Collectors.toList());
	}
	
	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> getVegGluFree () throws IOException {
		Predicate<Recipe> glutenFree = gf -> gf.getGlutenFree().booleanValue() == true;
		Predicate<Recipe> vegan = v -> v.getVegan().booleanValue() == true;
		
		return (List<Recipe>) fileService.readFile("recipes.txt").stream().filter(glutenFree.and(vegan)).collect(Collectors.toList());
	}

	@GetMapping("/vegetarian")
	public List<Recipe> getVegeterian () throws IOException {
		Predicate<Recipe> veget = v -> v.getVegetarian().booleanValue() == true;
		
		return (List<Recipe>) fileService.readFile("recipes.txt").stream().filter(veget).collect(Collectors.toList());
	}
	

}
