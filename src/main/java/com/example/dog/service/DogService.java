package com.example.dog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dog.domain.Dog;

@Service
public class DogService {
	
	private List<Dog> dogs = new ArrayList<>();
	
	public Dog createDog(Dog d) {
		this.dogs.add(d);
		Dog created = this.dogs.get(this.dogs.size() - 1);
		return created;
	}
	
	public List<Dog> getAllDogs() {
		return this.dogs;
	}
	
	public Dog getDog(Integer id) {
		return this.dogs.get(id);
	}
	
	public Dog replaceDog(Integer id, Dog newDog) {
		Dog body = this.dogs.set(id, newDog);
		return body;
	}
	
	public void removeDog(@PathVariable Integer id) {
		this.dogs.remove(id.intValue());
	}

}
