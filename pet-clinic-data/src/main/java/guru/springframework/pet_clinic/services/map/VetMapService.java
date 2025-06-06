package guru.springframework.pet_clinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.pet_clinic.model.Speciality;
import guru.springframework.pet_clinic.model.Vet;
import guru.springframework.pet_clinic.services.SpecialityService;
import guru.springframework.pet_clinic.services.VetService;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

	private SpecialityService specialityService;
	
	public VetMapService(SpecialityService specialityService) {
		super();
		this.specialityService = specialityService;
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

	@Override
	public Vet save(Vet object) {
		if (object.getSpecialities().size() > 0)
			object.getSpecialities().forEach(speciality -> {
				if (speciality.getId() == null) {
					Speciality savedSpeciality = specialityService.save(speciality);
					speciality.setId(savedSpeciality.getId());
				}
			});
		
		return super.save(object);
	}

}
