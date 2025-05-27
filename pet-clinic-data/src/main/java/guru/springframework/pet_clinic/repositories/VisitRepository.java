package guru.springframework.pet_clinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.pet_clinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
