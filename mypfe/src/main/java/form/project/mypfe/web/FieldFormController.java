/*
package form.project.mypfe.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import form.project.mypfe.service.FormService;

//@RestController

@Controller
@RequestMapping("/admin/items")
public class FieldFormController {

	@Autowired
	private final FormService formService;

	@Autowired
	public FieldFormController(FormService formService) {
		this.formService = formService;
	}*/

	// ADD FIEALFORM===========================================================

	/*
	 * @GetMapping(path="/addformitems") public String addFieldForm(Model model,
	 * FieldRequest fieldRequest) {
	 * 
	 * 
	 * FieldForm fieldForm = new FieldForm();
	 * 
	 * fieldRequest.setCheckbox(fieldForm.isCheckbox());
	 * fieldRequest.setColor(fieldForm.getColor());
	 * fieldRequest.setCols(fieldForm.getCols()); fieldRequest
	 * .setDescription(fieldForm.getDescription());
	 * fieldRequest.setId(fieldForm.getId()); fieldRequest
	 * .setLabel(fieldForm.getLabel()); fieldRequest .setMax(fieldForm.getMax());
	 * fieldRequest.setMaxlength(fieldForm.getMaxlength());
	 * fieldRequest.setMin(fieldForm.getMin());
	 * fieldRequest.setName(fieldForm.getName());
	 * fieldRequest.setOptions(fieldForm.getOptions());
	 * fieldRequest.setPosition(fieldForm.getPosition());
	 * fieldRequest.setRadio(fieldForm.isRadio());
	 * fieldRequest.setRow(fieldForm.getRow()); fieldRequest.setStatus(
	 * fieldForm.getStatus()); fieldRequest.setTitle( fieldForm.getTitle());
	 * fieldRequest.setType(fieldForm.getType()); fieldRequest.setSubTitle(
	 * fieldForm.getSubTitle()); fieldRequest.setValue(fieldForm.getValue());
	 * fieldRequest.setPosition(iFieldItemsFormService.countFormByStatus());
	 * 
	 * 
	 * model.addAttribute("fieldForm", fieldForm); model.addAttribute("mode","new");
	 * return "/admin/items/formitem"; }
	 */

	/*
	 * @GetMapping(path = "/addFormitem") public ModelAndView addFieldForm(Model
	 * model) { ModelAndView mv = new ModelAndView();
	 * mv.setViewName("/admin/items/formitem");
	 * 
	 * FieldForm fieldForm = new FieldForm(); mv.addObject("fieldForm", fieldForm);
	 * 
	 * return mv; }
	 * 
	 * // SAVE ADD=============================================================
	 * 
	 * @PostMapping(value = "/saveFormitems", params = { "addRow" }) public String
	 * saveFieldForm(Model model, FieldRequest fieldRequest, @RequestParam("addRow")
	 * String addRow, BindingResult bindingResult) { if (bindingResult.hasErrors())
	 * return "/admin/items/formitem";
	 * 
	 * FieldForm fieldForm = new FieldForm();
	 * 
	 * fieldForm = formService.createFieldForm(fieldRequest);
	 * model.addAttribute("fieldForm", fieldForm); return "/admin/items/formitem"; }
	 * 
	 * @GetMapping(path = "/update-fieldFormt/{id}") public String
	 * updateFieldForm(Model model, @PathVariable("id") String id, @RequestBody
	 * FieldRequest fieldRequest) {
	 * 
	 * FieldForm fieldForm = formService.updateFieldForm(fieldRequest);
	 * model.addAttribute("fieldForm", fieldForm); model.addAttribute("mode",
	 * "update"); return "admin/items/formitem"; }
	 * 
	 * @PostMapping("/position") public String changePosition(@RequestBody
	 * FieldRequest fieldRequest) { formService.changePosition(fieldRequest); return
	 * "admin/items/formitem"; }
	 * 
	 * @GetMapping(path = "/deleteField-form", params = { "removeRow" }) public
	 * String deleteFieldForm(String id) { formService.deleteFieldForm(id); return
	 * "/admin/items/formitem"; }
	 * 
	 * 
	 * // SHOW FIELD-FORM-LIST=====================================================
	 * 
	 * @GetMapping(path = "/displayformitems/{id}") public String
	 * displayFieldForm(Model model) { List<FieldForm> fieldForms =
	 * formService.getAllFieldForm(); model.addAttribute("fieldForms", fieldForms);
	 * return "/admin/items/formitem"; }
	 * 
	 * //try this
	 * 
	 * @RequestMapping("/showFieldform") public String showFieldform(Model model) {
	 * model.addAttribute("listFieldform", formService.getAllFieldForm()); return
	 * "/admin/items/formitem"; }

	
}
	 */