package com.process.week13;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// if scan is used, it should be the out most package aka the parent of other ones
//@ComponentScan("com.process")
public class Week13Application {

	public static void main(String[] args) {
		SpringApplication.run(Week13Application.class, args);		
		
	}

}
