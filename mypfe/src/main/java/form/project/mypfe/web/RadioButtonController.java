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
 * @RequestMapping("/admin/items") public class RadioButtonController {
 * 
 * @Autowired private IFieldFormService fieldFormService;
 * 
 * @Autowired private FieldFormRepository fieldFormRepository;
 * 
 * @RequestMapping("/addRadiobutton") public ModelAndView addRadiobutton(Model
 * model, FieldRequest fieldRequest) { ModelAndView mv = new ModelAndView();
 * mv.setViewName("/admin/items/formitem");
 * 
 * FieldForm fieldForm = new FieldForm();
 * fieldForm.setLabel(fieldRequest.getLabel());
 * fieldForm.setName(fieldRequest.getName());
 * fieldForm.setOptions(fieldRequest.getOptions());
 * fieldForm.setRadio(fieldRequest.isRadio());
 * fieldForm.setValue(fieldRequest.getValue());
 * fieldForm.setStatus(Status.TODO);
 * fieldForm.setPosition(fieldFormRepository.countFormByStatus(Status.TODO));
 * mv.addObject("radiof", fieldForm);
 * 
 * return mv;
 * 
 * }
 * 
 * // SAVE DATE FIELD
 * 
 * @PostMapping(path = "/saveRadio") public String saveRadio(Model model,
 * FieldRequest fieldRequest, BindingResult bindingResult) { if
 * (bindingResult.hasErrors()) return "admin/items/formitem";
 * 
 * FieldForm fieldForm = new FieldForm();
 * fieldForm.setLabel(fieldRequest.getLabel());
 * fieldForm.setName(fieldRequest.getName());
 * fieldForm.setOptions(fieldRequest.getOptions());
 * fieldForm.setRadio(fieldRequest.isRadio());
 * fieldForm.setValue(fieldRequest.getValue());
 * fieldForm.setStatus(Status.TODO);
 * fieldForm.setPosition(fieldFormRepository.countFormByStatus(Status.TODO));
 * 
 * 
 * fieldForm = fieldFormService.saveFieldForm(fieldRequest);
 * model.addAttribute("radiof", fieldForm); return "admin/items/formitem"; }
 * 
 * // UPDATE DATE FIELD=======================================================
 * 
 * @GetMapping(path = "/updateRadio") public String updateRadio(Model
 * model, @PathVariable("id") String id, @RequestBody FieldRequest fieldRequest)
 * {
 * 
 * FieldForm fieldForm = fieldFormService.updateFieldForm(fieldRequest);
 * model.addAttribute("form", fieldForm); model.addAttribute("mode", "update");
 * return "admin/items/formitem"; }
 * 
 * 
 * @PostMapping("/positionRadio") public String changePositionRadio(Model
 * model, @RequestBody FieldRequest formReques) {
 * 
 * fieldFormService.changePosition(formReques); model.addAttribute("formReques",
 * formReques);
 * 
 * return "admin/items/formitem"; }
 * 
 * @GetMapping(path = "/deleteRadio") public String deleteRadio(String id) {
 * fieldFormService.deleteFieldForm(id); return "admin/items/formitem"; }
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