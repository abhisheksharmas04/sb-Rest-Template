package com.ab.rest.template.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorServiceConsumerRunner_PathVariables implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// create rest-template class object
		RestTemplate restTemplate = new RestTemplate();
		// Define url
		String serviceUrl = "http://localhost:8081/actor/say/{id}/{name}";
		
		// passing as the argumet
		// In this type of approach arguments order should be compulsory
		ResponseEntity<String> response = restTemplate.getForEntity(serviceUrl,String.class,1001,"Raja");
		System.out.println("Respone Body: " + response.getBody());
		System.out.println("Response Status code value: " + response.getStatusCodeValue());
		System.out.println("Reponse status code: " + response.getStatusCode().name());
		System.out.println("Response headers:  "+ response.getHeaders().toString());
		
		// passing path variable as map
		// In this type of approach arguments order is not compulsory
		ResponseEntity<String>response2= restTemplate.getForEntity(serviceUrl,String.class, Map.of("id",1001,"name","Rajesh"));
		System.out.println("Respone Body: " + response2.getBody());
		System.out.println("Response Status code value: " + response2.getStatusCodeValue());
		System.out.println("Reponse status code: " + response2.getStatusCode().name());
		System.out.println("Response headers:  "+ response2.getHeaders().toString());
		

	}

}
