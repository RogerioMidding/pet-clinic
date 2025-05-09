package guru.springframework.pet_clinic.services;

import java.util.Set;

import guru.springframework.pet_clinic.model.Pet;

public interface PetService {

	Pet findById(Long id);
	
	Pet save(Pet  pet);
	
	Set<Pet> findAll();
	
}
