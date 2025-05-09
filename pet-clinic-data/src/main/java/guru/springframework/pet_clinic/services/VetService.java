package guru.springframework.pet_clinic.services;

import java.util.Set;

import guru.springframework.pet_clinic.model.Vet;

public interface VetService {
	
	Vet findById(Long id);
	
	Vet save(Vet vet);
	
	Set<Vet> findAll();

}
