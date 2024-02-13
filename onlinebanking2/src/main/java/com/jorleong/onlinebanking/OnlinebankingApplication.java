package com.jorleong.onlinebanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlinebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinebankingApplication.class, args);
		System.out.println("SPRING APPLICATION IS RUNNING");
	}
}
//change the repitories to match the domain types
//last left off at account deposit form in the views file

//steps to add more functionality:
//1. add a form for the controllerto map to, while editing the form's formAction..'
//2. reference the corresponding JPA repo file.
// add methods to the service interface file, then use the corresponding jpa default/ custom method from the impl file
//3. in order to make new controllers/more one-to-one,etc mappings create object for each other
//     in corresponding files, if many to one etc make sure to use an array.
//change the form line in the jsp file.

//can add fonts to the pdf viewer

//in excel make 1st row in bold

//fix the change authority