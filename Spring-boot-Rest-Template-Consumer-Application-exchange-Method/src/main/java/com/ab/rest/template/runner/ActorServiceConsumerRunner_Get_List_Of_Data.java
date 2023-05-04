package com.ab.rest.template.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ab.rest.template.model.Actor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ActorServiceConsumerRunner_Get_List_Of_Data implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// create rest-template class object
		RestTemplate restTemplate = new RestTemplate();
		// Define url
		String serviceUrl = "http://localhost:8081/actor/get/all/actors";

		// invoke the service method or operation using exchange() method
		ResponseEntity<String> response = restTemplate.exchange(serviceUrl,HttpMethod.GET,null,String.class);
		
		// Display the details
		System.out.println("Response Body: " + response.getBody());
		System.out.println("Response Status code: " + response.getStatusCode());
		System.out.println("Response Status code value: " + response.getStatusCodeValue());
		System.out.println("Response Status header value: " + response.getHeaders());
		
		// Convert String data into JSON
		String jsonBody = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		
		Actor[] actorsList = mapper.readValue(jsonBody,Actor[].class);
		System.out.println(actorsList.toString());
		
		// Direct conversion into list
		// DO RND on Goolge for this syntax
		//List<Actor> listActor1 = mapper.readValue(jsonBody,new TypeReferenceList<Actor>() {});

	}

}
