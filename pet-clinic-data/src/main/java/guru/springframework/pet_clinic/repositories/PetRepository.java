package guru.springframework.pet_clinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.pet_clinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
