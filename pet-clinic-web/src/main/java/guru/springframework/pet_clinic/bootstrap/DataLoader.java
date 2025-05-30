package guru.springframework.pet_clinic.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.pet_clinic.model.Owner;
import guru.springframework.pet_clinic.model.Pet;
import guru.springframework.pet_clinic.model.PetType;
import guru.springframework.pet_clinic.model.Speciality;
import guru.springframework.pet_clinic.model.Vet;
import guru.springframework.pet_clinic.model.Visit;
import guru.springframework.pet_clinic.services.OwnerService;
import guru.springframework.pet_clinic.services.PetTypeService;
import guru.springframework.pet_clinic.services.SpecialityService;
import guru.springframework.pet_clinic.services.VetService;
import guru.springframework.pet_clinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, 
			PetTypeService petTypeService, SpecialityService specialityService,
			VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		int count = petTypeService.findAll().size();
		
		if (count == 0)
			loadData();
		
	}
	
	private void loadData() {
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiology = specialityService.save(radiology);
		
		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = specialityService.save(surgery);
		
		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedDentistry = specialityService.save(dentistry);
	
		Owner owner1 = new Owner();
		owner1.setFirstName("Michel");
		owner1.setLastName("Weston");
		owner1.setAddress("123 Brickerel");
		owner1.setCity("Miami");
		owner1.setTelephone("1231231234");
		
		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Rosco");
		owner1.getPets().add(mikesPet);
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Gleanne");
		owner2.setAddress("123 Brickerel");
		owner2.setCity("Miami");
		owner2.setTelephone("1231231234");
		
		Pet fionnasCat = new Pet();
		fionnasCat.setName("Just Cat");
		fionnasCat.setOwner(owner2);
		fionnasCat.setBirthDate(LocalDate.now());
		fionnasCat.setPetType(savedCatPetType);
		owner2.getPets().add(fionnasCat);
		
		ownerService.save(owner2);
		
		Visit catVisit = new Visit();
		catVisit.setPet(fionnasCat);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Sneezy Kitty");
		
		visitService.save(catVisit);
		
		System.out.println("-------------- Loadded Owners --------------");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialities().add(savedRadiology);
		vet1.getSpecialities().add(dentistry);
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialities().add(savedSurgery);
		
		vetService.save(vet2);
		
		System.out.println("-------------- Loadded Vets --------------");
	}
	

}
