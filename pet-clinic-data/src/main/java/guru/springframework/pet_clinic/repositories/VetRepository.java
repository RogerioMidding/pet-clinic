package guru.springframework.pet_clinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.pet_clinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
