
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import form.project.mypfe.entity.FieldForm;
import form.project.mypfe.entity.HeaderField;
import form.project.mypfe.enums.Status;
import form.project.mypfe.service.IFormService;

@Controller // @RestController

@RequestMapping("/admin/items")
public class HeaderController {

	@Autowired
	private final IFormService iFieldFormService; 

	@Autowired
	public HeaderController(IFormService iFieldFormService) {
		this.iFieldFormService = iFieldFormService;
	}

	@GetMapping(path = "/heades") // json date wrks with // @RestController notation
  
  @RequestMapping(value = "/addHeader")
  
  @ResponseBody public ModelAndView addHeader(Model model, FieldForm
  fieldRequest) { ModelAndView mv = new ModelAndView();
  mv.setViewName("/admin/items/formitem");
  
  FieldForm fieldForm = new FieldForm();
  fieldForm.setTitle(fieldRequest.getTitle());
  fieldForm.setDescription(fieldRequest.getDescription());
  fieldForm.setStatus(Status.TODO);
  
  
  model.addAttribute("mode", "new");
  mv.addObject("head", fieldForm);
  
  return mv; }

	// SAVE ADD=============================================================

	@RequestMapping(value = "/saveHeader", params = { "addRow" }, method = RequestMethod.POST)
	public String saveHeader(Model model, FieldForm fieldRequest, @RequestParam("addRow") String addRow,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "/admin/items/formitem";

		FieldForm fieldForm = new FieldForm();
		fieldForm.setTitle(fieldRequest.getTitle());
		fieldForm.setDescription(fieldRequest.getDescription());

	//	fieldForm = iFieldFormService.saveHeader(fieldRequest);
		model.addAttribute("head", fieldForm);
		return "admin/items/formitem";
	}

	// UPDATE HEADER=======================================================

	@GetMapping(path = "/updateHeader")
	public String updateHeader(Model model, @PathVariable("id") String id, @RequestBody FieldForm fieldRequest) {
		
		HeaderField head = iFieldFormService.updateHeader(fieldRequest);
		model.addAttribute("head", head);
		model.addAttribute("mode", "update");
		return "admin/items/formitem";
	}

	@PostMapping("/positionHeader")
	public String changeHeader(Model model, @RequestBody FieldForm formReques) {

		iFieldFormService.headerPosition(formReques);
		model.addAttribute("formReques", formReques);

		return "admin/items/formitem";
	}

	@GetMapping(path = "/deleteHeader")
	public String deleteHeader(String id) {
		iFieldFormService.deleteHeade(id);
		return "admin/items/formitem";
	}

	@GetMapping(path = "/fieldformitems")
	public List<HeaderField> getFieldItemsForms() {
		List<HeaderField> list = iFieldFormService.getAllHeader();
		return list;
	}

	public List<HeaderField> getHeads() {
		List<HeaderField> list = iFieldFormService.getAllHeader();
		return list;
	}

}
