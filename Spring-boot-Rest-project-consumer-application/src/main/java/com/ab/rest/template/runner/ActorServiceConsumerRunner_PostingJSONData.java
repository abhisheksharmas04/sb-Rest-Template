package com.ab.rest.template.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumerRunner_PostingJSONData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// create rest-template class object
		RestTemplate restTemplate = new RestTemplate();
		
		// Define url
		String serviceUrl = "http://localhost:8081/actor/register";
		
		// Prepare json data (Request body)
		String json_Data = "{ \"aid\":1001, \"name\":\"suresh\",\"age\":30.0,\"type\":\"Hero\" }";
		
		// Prepare Headers
		// Passing headers is optional if we are sending JSON or Text data
		// While sending XML we have to pass headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		// Prepare Http Request as Http entity object having head, body
		HttpEntity<String> request = new HttpEntity<>(json_Data,headers);
		
		// send request-- make http request call in post mode
		ResponseEntity<String> response = restTemplate.postForEntity(serviceUrl, request, String.class);
																	// url		  request  output type
		
		System.out.println("Respone Body: " + response.getBody());
		System.out.println("Response Status code value: " + response.getStatusCodeValue());
		System.out.println("Reponse status code: " + response.getStatusCode().name());
		System.out.println("Response headers:  "+ response.getHeaders().toString());

	}

}

/*we can use postForEntity() or postForObject() methods of RestTemplate to send post mode request and
response completely or partially*/
