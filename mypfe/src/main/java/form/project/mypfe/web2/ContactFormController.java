package form.project.mypfe.web2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import form.project.mypfe.dao2.ContactFormRespository;
import form.project.mypfe.entity2.ContactForm;

@Controller
@RequestMapping("/admin/formLists")
public class ContactFormController {

	@Autowired
	private ContactFormRespository contactFormRespository;
	
	/*
	 * @GetMapping(path = "/contactForm") // @ResponseBody public String
	 * ContactForm() {
	 * 
	 * return"/admin/formLists/contactForm";
	 * 
	 * }
	 */
	 
	 
	 @GetMapping(path = "/templateDisplayList/showContact")
		public String listContact(Model model, 
				@RequestParam(name = "page", defaultValue = "0") int page,
				@RequestParam(name = "size", defaultValue = "6") int size,
				@RequestParam(name = "keywordcf", defaultValue = "") String mc) {

			Page<ContactForm> contactPage = contactFormRespository.findByfirstNameContains(mc, PageRequest.of(page, size));
			// Page <CnestProgram> cpPageProgs =
			// cProgramRepository.findAll(PageRequest.of(page, size));

			model.addAttribute("contactPage", contactPage.getContent());
			model.addAttribute("pages", new int[contactPage.getTotalPages()]);
			model.addAttribute("currentPage", page);
			model.addAttribute("size", size);
			model.addAttribute("keywordcf", mc);
			model.addAttribute("prev", page - 1);
			model.addAttribute("next", page + 1);
			return "/admin/formLists/templateDisplayList/displayListContactForm";
		}

		@GetMapping("/addContact")
		public ModelAndView addContact(Model model) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/admin/formLists/contactForm");
			ContactForm contact= new ContactForm();
			model.addAttribute("mode", "newcf");
			//model.addAttribute("mode", "add");
			mv.addObject("contact", contact);

			return mv;
		}

		// SAVE ADDInput =============================================================

		@RequestMapping(path = "/saveContact", method = RequestMethod.POST)
		public String saveContact(Model model, @ModelAttribute("contact") ContactForm contact,
				BindingResult bindingResult) {

			if (bindingResult.hasErrors())
				return "redirect:/admin/formLists/contactForm";

			ContactForm contacts = contactFormRespository.save(contact);
			model.addAttribute("contact", contacts);
			contacts.setFirstName("");
			contacts.setLastName("");
			contacts.setEmail("");
			contacts.setMessage("");
			contacts.setPhone("");
			
			return "/admin/formLists/contactForm";
			// return "/admin/formLists/templates-list::content";
		}

		// UPDATE HEADER=======================================================

		@GetMapping(path = "/updateContact")
		public String updateContact(Model model, Long id) {
			ContactForm contact = contactFormRespository.findById(id).get();
			model.addAttribute("contact", contact);
			model.addAttribute("mode", "updatecf");
			//model.addAttribute("mode", "Update");
			return "/admin/formLists/contactForm";
		}

		@GetMapping(value = "/templateDisplayList/deleteContact")
		public String deleteContact(Long id, String keywordcf, int page, int size, Model model) {
			contactFormRespository.deleteById(id);
			return listContact(model, page, size, keywordcf);
		}
		

		 
}
