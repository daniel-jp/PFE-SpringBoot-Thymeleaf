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

import form.project.mypfe.dao2.CategoryRepository;
import form.project.mypfe.entity2.Category;

@Controller
@RequestMapping("/admin/formLists")
public class CategoryController {
	

	@Autowired
	private CategoryRepository catRepository; 
	
	
	
	@GetMapping(path = "/templateDisplayList/showCateg")
	public String listOrg(Model model, 
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "keywordc", defaultValue = "") String mc) {

		Page<Category> categorPage = catRepository.findByNameContains(mc, PageRequest.of(page, size));
		// Page <CnestProgram> cpPageProgs =
		// cProgramRepository.findAll(PageRequest.of(page, size));

		model.addAttribute("categorPage", categorPage.getContent());
		model.addAttribute("pages", new int[categorPage.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("keywordc", mc);
		model.addAttribute("prev", page - 1); 
		model.addAttribute("next", page + 1);
		return "/admin/formLists/templateDisplayList/displayListCategory";
	}
 
	
	@GetMapping("/addCategory") 
	  public ModelAndView addCategory(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/formLists/category");
		Category category = new Category();
		model.addAttribute("mode", "new");
		mv.addObject("category", category);
			 
	return mv;
}
	 
	// SAVE ADDInput =============================================================
 
	@RequestMapping(path  = "saveCategory",  method = RequestMethod.POST)
	public String saveCategory(Model model, @ModelAttribute("category") Category category, BindingResult bindingResult) {
		 
		if (bindingResult.hasErrors())	return "redirect:/admin/formLists/templates-list";
		
		         category= catRepository.save(category);
			     model.addAttribute("category", category);  
			     return  "redirect:/admin/formLists/templates-list"; 
			     //return  "/admin/formLists/templates-list::content"; 
	}  

	// UPDATE HEADER=======================================================

	@GetMapping(path = "/updateCategory")
	public String updateCategory(Model model, Long id) {
		    Category category = catRepository.findById(id).get();
				model.addAttribute("category", category); 
				model.addAttribute("mode", "update");
		  return "/admin/formLists/category"; 
	}
      
	
	  @GetMapping(value  = "/templateDisplayList/deleteCategory") public String
	  deleteOrg(Long id, String keywordc, int page, int size, Model model) {
	  catRepository.deleteById(id); 
	  return listOrg(model, page, size, keywordc); }
	  
	/*
	 * @GetMapping(path = "/templateDisplayList/deleteCategory") public String
	 * delete3(Long id, String keywordc, int page, int size ) {
	 * catRepository.deleteById(id);
	 * 
	 * return "/admin/formLists/templateDisplayList/displayListCategory?page="+page+
	 * "&size="+size+"&keywordc="+keywordc; }
	 */

 
	
	
	
	
	
	

}
