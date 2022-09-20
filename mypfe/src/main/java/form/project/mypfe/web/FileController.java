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
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam; import
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
 * @RequestMapping("admin/items") public class FileController {
 * 
 * @Autowired private IFieldFormService iFieldFormService;
 * 
 * @Autowired private FieldFormRepository fieldFormRepository;
 * 
 * // SHOW FIELD-FORM-LIST=====================================================
 * 
 * @RequestMapping("/addFile") public ModelAndView addFile(Model model,
 * FieldRequest fieldRequest) { ModelAndView mv = new ModelAndView();
 * mv.setViewName("/admin/items/formitem");
 * 
 * FieldForm fieldForm = new FieldForm();
 * fieldForm.setLabel(fieldRequest.getLabel());
 * fieldForm.setName(fieldRequest.getName());
 * fieldForm.setOptions(fieldRequest.getOptions());
 * fieldForm.setType(fieldRequest.getType());
 * fieldForm.setValue(fieldRequest.getValue());
 * fieldForm.setStatus(Status.TODO);
 * fieldForm.setPosition(fieldFormRepository.countFormByStatus(Status.TODO));
 * 
 * model.addAttribute("mode", "new");
 * 
 * mv.addObject("filef", fieldRequest);
 * 
 * return mv; }
 * 
 * // SAVE ADDInput
 * =============================================================
 * 
 * @RequestMapping(value = "/saveFile", params = { "addRow" }, method =
 * RequestMethod.POST) public String saveFile(Model model, FieldRequest
 * fieldRequest, @RequestParam("addRow") String addRow, BindingResult
 * bindingResult) { if (bindingResult.hasErrors()) return
 * "admin/items/formitem";
 * 
 * FieldForm fieldForm = new FieldForm();
 * fieldForm.setLabel(fieldRequest.getLabel());
 * fieldForm.setName(fieldRequest.getName());
 * fieldForm.setOptions(fieldRequest.getOptions());
 * fieldForm.setType(fieldRequest.getType());
 * fieldForm.setValue(fieldRequest.getValue());
 * fieldForm.setStatus(Status.TODO);
 * fieldForm.setPosition(fieldFormRepository.countFormByStatus(Status.TODO));
 * 
 * fieldForm = iFieldFormService.saveFieldForm(fieldRequest);
 * model.addAttribute("filef", fieldForm); return "admin/items/formitem"; }
 * 
 * // UPDATE HEADER=======================================================
 * 
 * @GetMapping(path = "/updateFile") public String updateFile(Model
 * model, @PathVariable("id") String id, @RequestBody FieldRequest fieldRequest)
 * {
 * 
 * FieldForm fieldForm = iFieldFormService.updateFieldForm(fieldRequest);
 * model.addAttribute("form", fieldForm); model.addAttribute("mode", "update");
 * return "admin/items/formitem"; }
 * 
 * @PostMapping("/changeFiele") public String changeFiele(Model
 * model, @RequestBody FieldRequest formReques) {
 * 
 * iFieldFormService.changePosition(formReques);
 * model.addAttribute("formReques", formReques);
 * 
 * return "admin/items/formitem"; }
 * 
 * @GetMapping(path = "/deleteFile") public String deleteFile(String id) {
 * iFieldFormService.deleteFieldForm(id); return "admin/items/formitem"; }
 * 
 * }
 */