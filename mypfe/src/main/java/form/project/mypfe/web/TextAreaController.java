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
 * @RequestMapping("/admin/items") public class TextAreaController {
 * 
 * @Autowired private IFieldFormService iFieldFormService;
 * 
 * @Autowired private FieldFormRepository fieldFormRepository; // ADD TEXTAREA
 * 
 * @RequestMapping("/addTextarea") public ModelAndView addTextarea(Model
 * model,FieldRequest fieldRequest) {
 * 
 * ModelAndView mv = new ModelAndView();
 * mv.setViewName("/admin/items/formitem");
 * 
 * FieldForm fieldForm = new FieldForm();
 * fieldForm.setCheckbox(fieldRequest.isCheckbox());
 * fieldForm.setCols(fieldRequest.getCols());
 * fieldForm.setLabel(fieldRequest.getLabel());
 * fieldForm.setMaxlength(fieldRequest.getMaxlength());
 * fieldForm.setName(fieldRequest.getName());
 * fieldForm.setPlaceholder(fieldRequest.getPlaceholder());
 * fieldForm.setRow(fieldRequest.getRow());
 * fieldForm.setValue(fieldRequest.getValue());
 * fieldForm.setStatus(Status.TODO);
 * fieldForm.setPosition(fieldFormRepository.countFormByStatus(Status.TODO));
 * 
 * mv.addObject("fieldForm", fieldForm);
 * 
 * return mv; }
 * 
 * // SAVE TEXTAREA=============================================================
 * 
 * @PostMapping(path = "/saveTextarea") public String saveTextarea(Model model,
 * FieldRequest fieldRequest, BindingResult bindingResult) { if
 * (bindingResult.hasErrors()) return "admin/items/formitem";
 * 
 * FieldForm fieldForm = new FieldForm();
 * fieldForm.setCheckbox(fieldRequest.isCheckbox());
 * fieldForm.setCols(fieldRequest.getCols());
 * fieldForm.setLabel(fieldRequest.getLabel());
 * fieldForm.setMaxlength(fieldRequest.getMaxlength());
 * fieldForm.setName(fieldRequest.getName());
 * fieldForm.setPlaceholder(fieldRequest.getPlaceholder());
 * fieldForm.setRow(fieldRequest.getRow());
 * fieldForm.setValue(fieldRequest.getValue());
 * fieldForm.setStatus(Status.TODO);
 * fieldForm.setPosition(fieldFormRepository.countFormByStatus(Status.TODO));
 * 
 * 
 * fieldForm = iFieldFormService.saveFieldForm(fieldRequest);
 * model.addAttribute("textarea", fieldForm);
 * 
 * return "admin/items/formitem"; }
 * 
 * // UPDATE TEXTAREA=======================================================
 * 
 * 
 * 
 * 
 * @GetMapping(path = "/updateTextarea") public String updateTextarea(Model
 * model, @PathVariable("id") String id, @RequestBody FieldRequest fieldRequest)
 * {
 * 
 * FieldForm fieldForm = iFieldFormService.updateFieldForm(fieldRequest);
 * model.addAttribute("textarea", fieldForm); model.addAttribute("mode",
 * "update"); return "admin/items/formitem"; }
 * 
 * 
 * @PostMapping("/positionTextearea") public String changeTextarea(Model
 * model, @RequestBody FieldRequest formReques) {
 * 
 * 
 * iFieldFormService.changePosition(formReques);
 * model.addAttribute("formReques", formReques);
 * 
 * return "admin/items/formitem"; }
 * 
 * @GetMapping(path = "/deleteTeaxtarea") public String deleteTeaxtarea(String
 * id) { iFieldFormService.deleteFieldForm(id); return "admin/items/formitem"; }
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