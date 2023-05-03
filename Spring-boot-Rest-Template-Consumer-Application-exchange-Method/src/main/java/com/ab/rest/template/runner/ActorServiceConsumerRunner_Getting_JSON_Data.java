package com.ab.rest.template.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ab.rest.template.model.Actor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ActorServiceConsumerRunner_Getting_JSON_Data implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// create rest-template class object
		RestTemplate restTemplate = new RestTemplate();
		// Define url
		String serviceUrl = "http://localhost:8081/actor/find/{id}";
		
		// invoke the service method or operation using exchange() method
		ResponseEntity<String> response = restTemplate.exchange(serviceUrl, // Service URL
																HttpMethod.GET,
																null,
																String.class,
																101); // path variable value
		// If we are getting JSON data exchange() method will alwas contains string only. This string is contains JSON data
		
		// Display the details
		System.out.println("Response Body: " + response.getBody());
		System.out.println("Response Status code: " + response.getStatusCode());
		System.out.println("Response Status code value: " + response.getStatusCodeValue());
		System.out.println("Response Status header value: " + response.getHeaders());
		
		// converting JSON text response to Java class object-- Model class/ Entity class object using JACKSON api
		String json_Body = response.getBody();
		
		// Create Object mapper
		ObjectMapper mapper = new ObjectMapper();
		Actor actor = mapper.readValue(json_Body/*data to map*/, Actor.class /*class in which we want to map the data*/);
		System.out.println("Response as JSON: " + actor);
	}
	/*
	 * Once we add spring MVC starter to the project. We get JASCKON api automatically we can used to JSON data to object
	 * (Deserilization) and object to JSON (Serilization)
	 * Object Mapper JACKSON API methods:
	 *	mapper.readValue(): JSON text to Object (Deserialization)
	 *	mapper.writeValue(): Object to JSON text
	*/
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
