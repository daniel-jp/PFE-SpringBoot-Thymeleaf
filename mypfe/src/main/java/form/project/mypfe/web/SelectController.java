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
 * @RequestMapping("/admin/items") public class SelectController {
 * 
 * @Autowired private IFieldFormService iFieldFormService;
 * 
 * @Autowired private FieldFormRepository fieldFormRepository;
 * 
 * // ADD DATE //
 * FIELD=============================================================
 * 
 * @RequestMapping("/addSelect") public ModelAndView addSelect(Model model,
 * FieldRequest fieldRequest) { ModelAndView mv = new ModelAndView();
 * mv.setViewName("/admin/items/formitem");
 * 
 * FieldForm fieldForm = new FieldForm();
 * fieldForm.setCheckbox(fieldRequest.isCheckbox());
 * fieldForm.setLabel(fieldRequest.getLabel());
 * fieldForm.setMax(fieldRequest.getMax());
 * fieldForm.setName(fieldRequest.getName());
 * fieldForm.setValue(fieldRequest.getValue());
 * fieldForm.setStatus(Status.TODO);
 * fieldForm.setPosition(fieldFormRepository.countFormByStatus(Status.TODO));
 * 
 * mv.addObject("selectf", fieldRequest);
 * 
 * return mv; }
 * 
 * // SAVE DATE FIELD
 * 
 * @PostMapping(path = "/saveSelect") public String saveSelect(Model model,
 * FieldRequest fieldRequest, BindingResult bindingResult) { if
 * (bindingResult.hasErrors()) return "admin/items/formitem"; FieldForm
 * fieldForm = new FieldForm();
 * fieldForm.setCheckbox(fieldRequest.isCheckbox());
 * fieldForm.setLabel(fieldRequest.getLabel());
 * fieldForm.setMax(fieldRequest.getMax());
 * fieldForm.setName(fieldRequest.getName());
 * fieldForm.setValue(fieldRequest.getValue());
 * fieldForm.setStatus(Status.TODO);
 * fieldForm.setPosition(fieldFormRepository.countFormByStatus(Status.TODO));
 * 
 * fieldForm = iFieldFormService.saveFieldForm(fieldRequest);
 * model.addAttribute("selectf", fieldForm); return "admin/items/formitem"; }
 * 
 * /// UPDATE DATE FIELD=======================================================
 * 
 * @GetMapping(path = "/updateSelect") public String updateSelect(Model
 * model, @PathVariable("id") String id, @RequestBody FieldRequest fieldRequest)
 * {
 * 
 * FieldForm fieldform = iFieldFormService.updateFieldForm(fieldRequest);
 * model.addAttribute("fieldform", fieldform); model.addAttribute("mode",
 * "update"); return "admin/items/formitem"; }
 * 
 * @PostMapping("/positionSelect") public String changePositionSelect(Model
 * model, @RequestBody FieldRequest formReques) {
 * 
 * iFieldFormService.changePosition(formReques);
 * model.addAttribute("formReques", formReques);
 * 
 * return "admin/items/formitem"; }
 * 
 * @GetMapping(path = "/deleteSelect") public String deleteSelect(String id) {
 * iFieldFormService.deleteFieldForm(id); return "admin/items/formitem"; }
 * 
 * }
 */