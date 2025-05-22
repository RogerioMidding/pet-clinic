package guru.springframework.pet_clinic.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.pet_clinic.model.Owner;
import guru.springframework.pet_clinic.model.Pet;
import guru.springframework.pet_clinic.model.PetType;
import guru.springframework.pet_clinic.model.Vet;
import guru.springframework.pet_clinic.services.OwnerService;
import guru.springframework.pet_clinic.services.PetTypeService;
import guru.springframework.pet_clinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
	
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
		ownerService.save(owner2);
		
		Pet fionnasCat = new Pet();
		fionnasCat.setName("Just Cat");
		fionnasCat.setOwner(owner2);
		fionnasCat.setBirthDate(LocalDate.now());
		fionnasCat.setPetType(savedCatPetType);
		owner2.getPets().add(fionnasCat);
		
		System.out.println("-------------- Loadded Owners --------------");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		
		vetService.save(vet2);
		
		System.out.println("-------------- Loadded Vets --------------");
	}

}
