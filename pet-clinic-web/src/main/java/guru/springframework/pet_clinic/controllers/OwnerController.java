package guru.springframework.pet_clinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

	@RequestMapping({"", "/", "/index", "/index.html"})
	public String listwOwners() {
		
		return "owner/index";
	}
	
}
