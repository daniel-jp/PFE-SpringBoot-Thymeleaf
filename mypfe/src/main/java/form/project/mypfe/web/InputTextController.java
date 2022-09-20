
package form.project.mypfe.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import form.project.mypfe.entity.FieldForm;
import form.project.mypfe.entity.InputField;
import form.project.mypfe.service.IFormService;

@Controller
@RequestMapping("/admin/items")
public class InputTextController {

	@Autowired
	private final IFormService inputFieldService;

	
	@Autowired
    public InputTextController(IFormService inputFieldService) {
        this.inputFieldService = inputFieldService;
    }

	// SHOW FIELD-FORM-LIST=====================================================

	@RequestMapping("/addInput")
	public ModelAndView addInput(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/items/formitem");

		InputField inputField = new InputField(); 
		model.addAttribute("mode", "new");
		mv.addObject("inputField", inputField);
		return mv;
	}

	// SAVE ADDInput =============================================================

	@RequestMapping(value = "/saveInput", params = { "addRow" }, method = RequestMethod.POST)
	public String saveInput(Model model, FieldForm fieldForm, @RequestParam("addRow") String addRow,BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "/admin/items/formitem";

		InputField inputField = new InputField();
		inputField = inputFieldService.saveInput(fieldForm);
		model.addAttribute("inputField", inputField);
		return "/admin/items/formitem";
	}

	// UPDATE HEADER=======================================================

	@GetMapping(path = "/updateInput")
	public String updateInput(RedirectAttributes re, Model model, @PathVariable("id") String id, @RequestBody  FieldForm fieldForm) {
		InputField inputField = inputFieldService.updateInput(fieldForm);
		model.addAttribute("inputField", inputField);
		model.addAttribute("mode", "update");
		return "/admin/items/formitem";
	}

	@PostMapping("/positionInput")
	public String changeInput(Model model, @RequestBody FieldForm fieldFormt) {

		inputFieldService.inputPosition(fieldFormt); 
		model.addAttribute("fieldForm", fieldFormt);

		return "admin/items/formitem";
	}
	
	@GetMapping(path = "/deleteInput/{id}",  params = {"removeRow"})
	public String deleteInput(Model model, String id, @RequestParam("removeRow") String removeRow ) {

		inputFieldService.deleteInput(id);
		return "/admin/items/formitem";
}

	@GetMapping(path = "/displayinput")
	public String displayInput(Model model) {
		List<InputField> inputFields = inputFieldService.getAllInput();
		model.addAttribute("inputFields", inputFields);
		return "admin/items/formitem";
	}
	
	//try this
	@RequestMapping("/dispFieldform")
	public String dispFieldform(Model model) 
	{
	    model.addAttribute("listFieldform", inputFieldService.getAllInput());
		return "/admin/items/formitem";
	}

}
