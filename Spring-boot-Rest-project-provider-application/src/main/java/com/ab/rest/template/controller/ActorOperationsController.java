package com.ab.rest.template.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ab.rest.template.model.Actor;

@RestController
@RequestMapping("/actor")
public class ActorOperationsController {

	@GetMapping("/wish")
	public ResponseEntity<String> displayWishMessage() {
		return new ResponseEntity<String>("Good Morning", HttpStatus.OK);
	}

	@GetMapping("/say/{id}/{name}")
	public ResponseEntity<String> displayWishMessageByIdAndName(@PathVariable Integer id, @PathVariable String name) {
		return new ResponseEntity<String>("Good Morning " + id + "...." + name, HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor) {
		return new ResponseEntity<String>("Actor data: " + actor.toString(), HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Actor> searchActor(@PathVariable("id") Integer id) {
		return new ResponseEntity<Actor>(new Actor(101, "Akshay", 50, "Hero"), HttpStatus.OK);
	}

	@GetMapping("/get/all/actors")
	public ResponseEntity<List<Actor>> featchAllActors() {
		return new ResponseEntity<List<Actor>>(
				List.of(new Actor(101, "Akshay", 50, "Hero"), 
						new Actor(102, "Salman", 30, "Hero"),
						new Actor(103, "Rekha", 34, "Heroien"), 
						new Actor(101, "Jaya", 45, "Heroien")),
				HttpStatus.OK);
	}

}