package com.example.dog.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dog.domain.Dog;
import com.example.dog.service.DogService;

@RestController
public class DogController {
	
	@GetMapping("/bark")
	public String bark() {
		return "Woof";
	}
	
	private DogService service;
	
	@Autowired
	public DogController(DogService service) {
		super();
		this.service = service;
	}
	
	
	
	@PostMapping("/create") // 201
	public ResponseEntity<Dog> createDog(@RequestBody Dog d) {
		Dog created = this.service.createDog(d);
		ResponseEntity<Dog> response = new ResponseEntity<Dog>(created,HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping("/getAll") // 200
	public ResponseEntity<List<Dog>> getAllDogs() {
		return ResponseEntity.ok(this.service.getAllDogs());
	}
	
	@GetMapping("/get/{id}") // 200
	public Dog getDog(@PathVariable Integer id) {
		return this.service.getDog(id);
	}
	
	@PutMapping("/replace/{id}") //202
	public ResponseEntity<Dog> replaceDog(@PathVariable Integer id, @RequestBody Dog newDog) {
		Dog body = this.service.replaceDog(id, newDog);
		ResponseEntity<Dog> response = new ResponseEntity<Dog>(body, HttpStatus.ACCEPTED);
		return response;
	}
	
	@DeleteMapping("/remove/{id}") // 204
	public ResponseEntity<?> removeDog(@PathVariable Integer id) {
		this.service.removeDog(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
