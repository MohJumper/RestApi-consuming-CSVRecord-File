package com.process.week13.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.process.week13.Recipe;

// this were you actually read the file from.

@Service
public class FileService {
		
	public List<Recipe> readFile(String fileName) throws IOException{
		
		List<Recipe> lsRecipes = new ArrayList<Recipe>();
		
		try {
			Reader in = new FileReader("recipes.txt");
			Iterable<CSVRecord> recipes;
			recipes = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces().withHeader().withEscape('\\').parse(in);

			for (CSVRecord recipe : recipes) {
		    Recipe eachRecipe = getOneRecipe(recipe);
		    lsRecipes.add(eachRecipe);

		}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lsRecipes;
		
	}
	
	// helpful resource https://www.youtube.com/watch?v=Bu2VMptJaHs&list=LL&index=1&t=692s
	private Recipe getOneRecipe(CSVRecord recipe ){
		
//			System.out.println(recipe.get(0));
	    int cookingMinutes = Integer.parseInt(recipe.get(0));
	    Boolean dairyFree =  Boolean.parseBoolean(recipe.get(1));
	    Boolean glutenFree = Boolean.parseBoolean(recipe.get(2));
	    String instructions = recipe.get(3);
	    Double preparationMinutes =  Double.parseDouble(recipe.get(4));
	    Double pricePerServing = Double.parseDouble(recipe.get(5));
	    int readyInMinutes = Integer.parseInt(recipe.get(6));
	    int servings = Integer.parseInt(recipe.get(7));
	    Double spoonacularScore = Double.parseDouble(recipe.get(8));
	    String title = recipe.get(9);
	    Boolean vegan = Boolean.parseBoolean(recipe.get(10));
	    Boolean vegetarian = Boolean.parseBoolean(recipe.get(11));
	    
	    Recipe rec = new Recipe(cookingMinutes, dairyFree, glutenFree, instructions, 
	    		preparationMinutes, pricePerServing, readyInMinutes, servings, 
	    		spoonacularScore, title, vegan, vegetarian);
		
	    return rec;
	}
	
	
	

}
