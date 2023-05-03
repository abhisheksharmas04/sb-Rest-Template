package com.ab.rest.template.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumerRunner_exchange_With_Post_Json_Data implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// create rest-template class object
		RestTemplate restTemplate = new RestTemplate();
		// Define url
		String serviceUrl = "http://localhost:8081/actor/register";
		
		// Create JSON data
		String json_Data = "{ \"aid\":1001, \"name\":\"Kapil-Dev\",\"age\":30.0,\"type\":\"Hero\" }";
		
		// Prepare Headers
		// Passing headers is optional if we are sending JSON or Text data
		// While sending XML we have to pass headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Prepare Http Request as Http entity object having head, body
		HttpEntity<String> request = new HttpEntity<>(json_Data, headers);
		
		// invoke the service method or operation using exchange() method
		ResponseEntity<String> response = restTemplate.exchange(serviceUrl, // Service URL
																HttpMethod.POST, // Here we need to pass http method, HTTPMETHOD are enum in Http class
																request,// Body of the POST mode request
																String.class); // path variable value
		
		// Display the details
		System.out.println("Response Body: " + response.getBody());
		System.out.println("Response Status code: " + response.getStatusCode());
		System.out.println("Response Status code value: " + response.getStatusCodeValue());
		System.out.println("Response Status header value: " + response.getHeaders());
	}
}

/*
 * exchange() method is alternate to the following methods:
 * 	getForEntity()
 *  postForEntity()
 *  getForObject()
 *  postForObject()
 *  delete()
 *  put()
 *  patchForEntity()
 *  patchForObject() 
*/
