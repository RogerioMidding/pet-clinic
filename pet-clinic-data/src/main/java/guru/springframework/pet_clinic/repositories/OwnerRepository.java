package guru.springframework.pet_clinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.pet_clinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
