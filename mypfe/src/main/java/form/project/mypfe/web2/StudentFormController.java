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

import form.project.mypfe.dao2.StudentFormRepository;
import form.project.mypfe.entity2.StudentForm;

@Controller
@RequestMapping("/admin/formLists")
public class StudentFormController {

	@Autowired
	private StudentFormRepository studentFormRepository;

	/*
	 * @GetMapping(path = "/studantForm") // @ResponseBody public String Studant() {
	 * 
	 * return "/admin/formLists/studantForm";
	 * 
	 * }
	 */

	@GetMapping(path = "/templateDisplayList/showStudent")
	public String listStudent(Model model, 
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size,
			@RequestParam(name = "keywords", defaultValue = "") String mc) {

		Page<StudentForm> studPage = studentFormRepository.findByfirstNameContains(mc, PageRequest.of(page, size));
		// Page <CnestProgram> cpPageProgs =
		// cProgramRepository.findAll(PageRequest.of(page, size));

		model.addAttribute("studPage", studPage.getContent());
		model.addAttribute("pages", new int[studPage.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("keywords", mc);
		model.addAttribute("prev", page - 1);
		model.addAttribute("next", page + 1);
		return "/admin/formLists/templateDisplayList/displayListStudantForm";
	}

	@GetMapping("/addStudent")
	public ModelAndView addStudent(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/formLists/studantForm");
		StudentForm student = new StudentForm();
		model.addAttribute("mode", "new");
		mv.addObject("student", student);

		return mv;
	}

	// SAVE ADDInput =============================================================

	@RequestMapping(path = "/saveStudent", method = RequestMethod.POST)
	public String saveStudent(Model model, @ModelAttribute("studentForm") StudentForm studentForm,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors())
			return "redirect:/admin/formLists/studantFormt";

		StudentForm student = studentFormRepository.save(studentForm);
		model.addAttribute("student", student);
		return "/admin/formLists/templates-list";
		// return "/admin/formLists/templates-list::content";
	}

	// UPDATE HEADER=======================================================

	@GetMapping(path = "/updateStudentForm")
	public String updateStudentForm(Model model, Long id) {
		StudentForm student = studentFormRepository.findById(id).get();
		model.addAttribute("student", student);
		model.addAttribute("mode", "update");
		return "/admin/formLists/studantForm";
	}

	@GetMapping(value = "/templateDisplayList/deleteStudent")
	public String deleteStudent(Long id, String keywords, int page, int size, Model model) {
		studentFormRepository.deleteById(id);
		return listStudent(model, page, size, keywords);
	}

}
