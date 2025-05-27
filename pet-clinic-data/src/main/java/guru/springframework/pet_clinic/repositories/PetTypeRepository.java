package guru.springframework.pet_clinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.pet_clinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
