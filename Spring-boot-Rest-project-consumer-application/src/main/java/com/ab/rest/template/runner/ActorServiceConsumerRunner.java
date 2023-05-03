package com.ab.rest.template.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorServiceConsumerRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// create rest-template class object
		RestTemplate restTemplate = new RestTemplate();
		// Define url
		String serviceUrl = "http://localhost:8081/actor/wish";
		// Generate http request call with get mode to consume the web service
		/*ResponseEntity<String> response = restTemplate.getForEntity(serviceUrl,String.class);
		// display the recived details from the response
		System.out.println("Respone Body: " + response.getBody());
		System.out.println("Response Status code value: " + response.getStatusCodeValue());
		System.out.println("Reponse status code: " + response.getStatusCode().name());
		// or we can use toString() also instead of getStatusCode().name();
		
		System.exit(0);*/
		
		//-----------------------getForObject()method-------------------------------------------------
		// This method will return only object, No respone status and response code nothing
		Object object = restTemplate.getForObject(serviceUrl,String.class);
		System.out.println("response body: " + object);
		//-----------------------getForObject()method-------------------------------------------------
		
		//-----------------------getForObject()method-------------------------------------------------

	}

}
