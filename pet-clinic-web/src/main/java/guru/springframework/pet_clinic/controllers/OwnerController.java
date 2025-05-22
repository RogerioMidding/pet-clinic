package guru.springframework.pet_clinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.pet_clinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

	private final OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@RequestMapping({"", "/", "/find", "/index", "/index.html"})
	public String listwOwners(Model model) {
		model.addAttribute("owners", ownerService.findAll());
		return "owner/index";
	}
	
}
