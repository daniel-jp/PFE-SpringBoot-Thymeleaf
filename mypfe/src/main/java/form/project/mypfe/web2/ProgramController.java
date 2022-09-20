package form.project.mypfe.web2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import form.project.mypfe.dao2.CategoryRepository;
import form.project.mypfe.dao2.ProgramRepository;
import form.project.mypfe.entity2.Category;
import form.project.mypfe.entity2.Program;
import form.project.mypfe.enums2.City;

@Controller
@RequestMapping("/admin/formLists")
public class ProgramController {

	@Autowired
	private ProgramRepository pRepository;

	@Autowired
	private CategoryRepository cRepository;

	/*
	 * private ITemplatesService iTemplatesService;
	 */

	@GetMapping(path = "/templateDisplayList/showProgram")
	public String list(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "keyword", defaultValue = "") String mc) {

		Page<Program> programs = pRepository.findByNameContains(mc, PageRequest.of(page, size));
		// Page <CnestProgram> cpPageProgs =
		// cProgramRepository.findAll(PageRequest.of(page, size));

		model.addAttribute("programs", programs.getContent());
		model.addAttribute("pages", new int[programs.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("keyword", mc);
		model.addAttribute("prev", page - 1);
		model.addAttribute("next", page + 1);
		return "/admin/formLists/templateDisplayList/displayListProgram";
	}

	// add new =============================================================

	/*
	 * @GetMapping(path = "/addprogram") public ModelAndView addprogram(Model model)
	 * {
	 * 
	 * ModelAndView mav = new ModelAndView("/admin/formLists/program"); Program
	 * program = new Program(); List<Category> list = categoryRepository.findAll();
	 * //model.addAttribute("program", new CnestProgram());
	 * mav.addObject("categories", list); mav.addObject("cities", City.values());
	 * model.addAttribute("mode", "new"); mav.addObject("program", program);
	 * 
	 * return mav; }
	 */

	@GetMapping("/addprogram")
	public ModelAndView addProgram(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/formLists/program");
		
		List<Category> categories = cRepository.findAll();
		Program program = new Program();
		model.addAttribute("categories", categories);
		model.addAttribute("cities", City.values());
		model.addAttribute("mode", "newp");
		mv.addObject("program", program);

		return mv;
	}

	// SAVE ADDInput =============================================================

	@PostMapping(path = "/templateDisplayList/saveProgram")

	public String saveIProgram(Model model, @ModelAttribute("program") Program program, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {

			return "/admin/formLists/program";
		} else {

			pRepository.save(program);
			model.addAttribute("program", program);
			
		}
		return "redirect:/admin/formLists/templates-list";
	}

	// UPDATE PROGRAM=======================================================

	/*
	 * @GetMapping(path = "/deleteProgram") public String deleteProgram(Long id,
	 * String keyword, int page, int size ) { iService.deleteProgram(id);
	 * 
	 * return
	 * "redirect:/admin/formLists/templateDisplayList/DisplayListProgram?page= "
	 * +page+"&size = "+ size +"&keyword="+keyword; }
	 */
	
	

	@GetMapping(path = "/templateDisplayList/deleteProgram2")
	public String delete2(Long id, String keyword, int page, int size, Model model) {
		pRepository.deleteById(id);
		return list(model, page, size, keyword);
	}

	
	@GetMapping(path = "/updateprogram")
	public String updateStudentForm(Model model, Long id,  Long idc) {
		Program program = pRepository.findById(id).get();
		Category categories = cRepository.findById(idc).get();
		model.addAttribute("program", program);
		model.addAttribute("categories", categories); 
		model.addAttribute("cities", City.values());
		model.addAttribute("mode", "updatep");
		return "/admin/formLists/program";
	}
	

	 	/* 
	@RequestMapping(value = "/updateprogram/{id}", method = RequestMethod.GET) 
	  public ModelAndView updateProgram(Model model, Long id) { 
		  
		  ModelAndView mav = new ModelAndView("/admin/formLists/program");
	      Program  program = pRepository.findById(id).get();
	      model.addAttribute("mode", "update");
	      mav.addObject("program", program); 
	  
	  return mav; 
	  } */
	 
}
