package guru.springframework.pet_clinic.services;

import guru.springframework.pet_clinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	
	Owner findByLastName(String lastName);
	
}
