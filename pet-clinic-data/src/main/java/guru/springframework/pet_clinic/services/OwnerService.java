package guru.springframework.pet_clinic.services;

import java.util.Set;

import guru.springframework.pet_clinic.model.Owner;

public interface OwnerService {
	
	Owner findByLastName(String lastName);
	
	Owner findById(Long id);
	
	Owner save(Owner owner);
	
	Set<Owner> findAll();

}
