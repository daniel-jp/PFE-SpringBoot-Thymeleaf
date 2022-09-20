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

import form.project.mypfe.dao2.JobFormRepository;
import form.project.mypfe.entity2.JobForm;
import form.project.mypfe.enums2.Radio;

@Controller
@RequestMapping("/admin/formLists")
public class JobFormController {
	
	@Autowired
	private JobFormRepository jobFormRepository;
	
	/*
	 * @GetMapping(path = "/jobForm") // @ResponseBody public String jobForm() {
	 * 
	 * return"/admin/formLists/jobForm";
	 * 
	 * }
	 * 
	 */
	 
	 @GetMapping(path = "/templateDisplayList/showJobForm")
		public String listJobForm(Model model, 
				@RequestParam(name = "page", defaultValue = "0") int page,
				@RequestParam(name = "size", defaultValue = "3") int size,
				@RequestParam(name = "keywordj", defaultValue = "") String mc) {

			Page<JobForm> jobPage = jobFormRepository.findByfullNameContains(mc, PageRequest.of(page, size));
			// Page <CnestProgram> cpPageProgs =
			// cProgramRepository.findAll(PageRequest.of(page, size));

			model.addAttribute("jobPage", jobPage.getContent());
			model.addAttribute("pages", new int[jobPage.getTotalPages()]);
			model.addAttribute("currentPage", page);
			model.addAttribute("size", size);
			model.addAttribute("keywordj", mc);
			model.addAttribute("prev", page - 1);
			model.addAttribute("next", page + 1);
			return "/admin/formLists/templateDisplayList/displayListJobForm";
		}

		@GetMapping("/jobForm")
		public ModelAndView addJob(Model model) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/admin/formLists/jobForm");
			JobForm jobForm = new JobForm();
			model.addAttribute("allradios", Radio.values());
			model.addAttribute("mode", "newj");
			mv.addObject("jobForm", jobForm);

			return mv;
		}

		// SAVE ADDInput =============================================================

		@RequestMapping(path = "/saveJob", method = RequestMethod.POST)
		public String saveJob(Model model, @ModelAttribute("jobForm") JobForm jobForm,
				BindingResult bindingResult) {

			if (bindingResult.hasErrors())
				return "redirect:/admin/formLists/jobForm";

			JobForm jobForm2 = jobFormRepository.save(jobForm);
			model.addAttribute("jobForm", jobForm2);
			return "/admin/formLists/templates-list";
			// return "/admin/formLists/templates-list::content";
		}

		// UPDATE HEADER=======================================================

		@GetMapping(path = "/updateJobForm")
		public String updateJobForm(Model model, Long id) {
			JobForm jobForm = jobFormRepository.findById(id).get();
			model.addAttribute("jobForm", jobForm);
			model.addAttribute("allradios", Radio.values());
			model.addAttribute("mode", "updatej");
			return "/admin/formLists/jobForm";
		}
 
		@GetMapping(value = "/templateDisplayList/deleteJobForm")
		public String deleteJobForm(Long id, String keywordj, int page, int size, Model model) {
			jobFormRepository.deleteById(id);
			return listJobForm(model, page, size, keywordj);
		}

		 

}
