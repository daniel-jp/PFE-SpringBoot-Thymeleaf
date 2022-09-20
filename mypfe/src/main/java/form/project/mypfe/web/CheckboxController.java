/*
 * package form.project.mypfe.web;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.validation.BindingResult; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.servlet.ModelAndView;
 * 
 * import form.project.mypfe.dao.FieldFormRepository; import
 * form.project.mypfe.entity.FieldForm; import
 * form.project.mypfe.entity.FieldRequest; import
 * form.project.mypfe.enums.Status; import
 * form.project.mypfe.service.IFieldFormService;
 * 
 * @Controller
 * 
 * @RequestMapping("/admin/items") public class CheckboxController {
 * 
 * @Autowired private IFieldFormService iFieldFormService; // SHOW
 * 
 * @Autowired private FieldFormRepository fieldFormRepository;
 * 
 * // ADD DATE //
 * FIELD=============================================================
 * 
 * @RequestMapping("/addCheckbox") public ModelAndView addCheckbox(Model model,
 * FieldRequest fieldRequest) { ModelAndView mv = new ModelAndView();
 * mv.setViewName("/admin/items/formitem");
 * 
 * FieldForm fieldForm = new FieldForm();
 * fieldForm.setCheckbox(fieldRequest.isCheckbox()); fieldForm .setLabel(
 * fieldRequest.getLabel()); fieldForm.setName(fieldRequest.getName());
 * fieldForm.setOptions(fieldRequest.getOptions());
 * fieldForm.setValue(fieldRequest.getValue());
 * fieldForm.setStatus(Status.TODO);
 * fieldForm.setPosition(fieldFormRepository.countFormByStatus(Status.TODO));
 * 
 * 
 * model.addAttribute("mode", "new"); mv.addObject("checkbf",fieldRequest );
 * 
 * return mv; }
 * 
 * // SAVE DATE FIELD
 * 
 * @PostMapping(path = "/saveCheckbox") public String saveCheckbox(Model model,
 * FieldRequest fieldRequest, BindingResult bindingResult) { if
 * (bindingResult.hasErrors()) return "admin/items/formitem";
 * 
 * FieldForm fieldForm = new FieldForm();
 * fieldForm.setCheckbox(fieldRequest.isCheckbox()); fieldForm .setLabel(
 * fieldRequest.getLabel()); fieldForm.setName(fieldRequest.getName());
 * fieldForm.setOptions(fieldRequest.getOptions());
 * fieldForm.setValue(fieldRequest.getValue());
 * fieldForm.setStatus(Status.TODO);
 * fieldForm.setPosition(fieldFormRepository.countFormByStatus(Status.TODO));
 * 
 * 
 * fieldForm = iFieldFormService.saveFieldForm(fieldRequest);
 * model.addAttribute("checkbf", fieldForm); return "admin/items/formitem"; }
 * 
 * /// UPDATE DATE FIELD=======================================================
 * 
 * @GetMapping(path = "/updateCheckbox") public String updateCheckbox(Model
 * model, @PathVariable("id") String id, @RequestBody FieldRequest fieldRequest)
 * {
 * 
 * FieldForm fieldForm = iFieldFormService.updateFieldForm(fieldRequest);
 * model.addAttribute("form", fieldForm); model.addAttribute("mode", "update");
 * return "admin/items/formitem"; }
 * 
 * 
 * @PostMapping("/positionCheckbox") public String positionCheckbox(Model
 * model, @RequestBody FieldRequest formReques) {
 * iFieldFormService.changePosition(formReques); return "admin/items/formitem";
 * }
 * 
 * @GetMapping(path = "/deleteCheckBox") public String deleteForms(String id) {
 * iFieldFormService.deleteFieldForm(id); return "admin/items/formitem"; }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */