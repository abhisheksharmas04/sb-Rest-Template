package com.ab.rest.template.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorServiceConsumerRunner_Exchange_GET_Mode_Request implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// create rest-template class object
		RestTemplate restTemplate = new RestTemplate();
		// Define url
		String serviceUrl = "http://localhost:8081/actor/wish";
		
		// invoke the service method or operation using exchange() method
		ResponseEntity<String> response = restTemplate.exchange(serviceUrl, // Service URL
																HttpMethod.GET, // Here we need to pass http method, HTTPMETHOD are enum in Http class
																null,// Because GET mode request does not contain any body so we are passing null
																String.class);
		
		// Display the details
		System.out.println("Response Body: " + response.getBody());
		System.out.println("Response Status code: " + response.getStatusCode());
		System.out.println("Response Status code value: " + response.getStatusCodeValue());
		System.out.println("Response Status header value: " + response.getHeaders());
	}
}
