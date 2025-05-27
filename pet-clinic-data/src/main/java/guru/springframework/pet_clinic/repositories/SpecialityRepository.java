package guru.springframework.pet_clinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.pet_clinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {

}
