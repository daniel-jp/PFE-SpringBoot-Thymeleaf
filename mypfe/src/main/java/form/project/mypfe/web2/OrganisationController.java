package form.project.mypfe.web2;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import form.project.mypfe.dao2.CategoryRepository;
import form.project.mypfe.dao2.OrganisationRepository;
import form.project.mypfe.entity2.Category;
import form.project.mypfe.entity2.Organisation;
import form.project.mypfe.enums2.City;

@Controller
@RequestMapping("/admin/formLists")
public class OrganisationController {
	
	
	@Autowired
	private OrganisationRepository oRepository;

	@Autowired
	private CategoryRepository cRepository;
	/*
	 * @GetMapping(path = "/addOrganisation") // @ResponseBody public String
	 * addOrganisation() {
	 * 
	 * return"/admin/formLists/addOrganisation";
	 * 
	 * }
	 */
	


	@GetMapping(path = "/templateDisplayList/showOrganization")
	public String listOrg(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "keyword", defaultValue = "") String mc) {

		Page<Organisation> orgaPages = oRepository.findByNameContains(mc, PageRequest.of(page, size));
		// Page <CnestProgram> cpPageProgs =
		// cProgramRepository.findAll(PageRequest.of(page, size));

		model.addAttribute("orgaPages", orgaPages.getContent());
		model.addAttribute("pages", new int[orgaPages.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("keyword", mc);
		model.addAttribute("prev", page - 1);
		model.addAttribute("next", page + 1);
		return "/admin/formLists/templateDisplayList/displayOrgonization";
	}
 
	  
		 @GetMapping(path = "/addOrganisation") 
		  public String addOrganisation(Model model) {
			 List<Category> listCategories = cRepository.findAll();
			 model.addAttribute("organization", new Organisation());
			 model.addAttribute("categories", listCategories);
			 model.addAttribute("cities", City.values());
			 model.addAttribute("mode", "new");
			  return "/admin/formLists/addOrganisation";
		  }
		 
		 @PostMapping( "/saveOrganisation")
		 public String saveOrganisation(Model model, @Valid Organisation organization, BindingResult bindingResult) {
			 
			 if(bindingResult.hasErrors())	return "/admin/formLists/organisation";

			 oRepository.save(organization);
	        model.addAttribute("organization", organization);
	    	return "redirect:/admin/formLists/templates-list";
			 
		 }
		 
		 @GetMapping(path = "/templateDisplayList/deleteorgasation")
			public String deleteorgazation(Long id, String keyword, int page, int size, Model model) {
			 oRepository.deleteById(id);
				return listOrg(model, page, size, keyword);
			}

			@RequestMapping(value = "/updateorg/{id}", method = RequestMethod.GET) 
			public String updateorg(Model model, Long id) {

				Organisation pg = oRepository.findById(id).get();
				model.addAttribute("organization", pg);
				model.addAttribute("mode", "update");

				return "/admin/formLists/organization";
			}
			


}
