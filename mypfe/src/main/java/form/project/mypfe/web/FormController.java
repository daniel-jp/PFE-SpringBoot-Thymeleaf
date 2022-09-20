
package form.project.mypfe.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import form.project.mypfe.entity.Form;
import form.project.mypfe.service.IFormService;

@Controller
  
  @RequestMapping(path = "/admin/items") 

public class FormController {
  
  @Autowired 
  private final IFormService iFormService;
  
  @Autowired 
  public FormController(IFormService iFormService) {
              this.iFormService = iFormService;
  }
/*
 * @RequestMapping("/addForm") public String addForm(Model model) {
 * model.addAttribute("form", new Form()); model.addAttribute("mode","new");
 * return "admin/items/formitem";
 * 
 * }
 */
  
    @RequestMapping("/addForm")
	public ModelAndView addForm(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/items/formitem");
		Form form = new Form();
		model.addAttribute("mode", "new");
		mv.addObject("form", form);
		return mv;
	}
  
  // SAVE ADDInput=============================================================
  
  @RequestMapping(value = "/saveForm", params = {"addRow" }, method = RequestMethod.POST) 
  public String saveForm(Model model, Form form, @RequestParam("addRow") String addRow, BindingResult bindingResult) {
  if(bindingResult.hasErrors()) return "/admin/items/formitem";
  
  Form formf = iFormService.saveForm(form);
  model.addAttribute("form", formf); 
  return"/admin/items/formitem";                                                                                                                                                                                                                                                                                                                                        
 }
  //@RequestParam("addRow") String addRow,
  // UPDATE HEADER=======================================================
  
  @GetMapping(path = "/updateForm") 
  public String updateForm(Model model, String id) {
  
  Form form = iFormService.updateForm(id); 
  model.addAttribute("form", form); 
  model.addAttribute("mode", "update");
  return "admin/items/formitem";
 }
  
  
  @GetMapping(path = "/deleteForm")
  public String deleteForms(String id) {
	  iFormService.deleteForm(id);
	  return "admin/items/formitem"; }
  
  
	@PostMapping("/positionForm")
	public String changeInput(Model model, @RequestBody Form form) {

		iFormService.changePosition(form); 
		model.addAttribute("form", form);

		return "admin/items/formitem";
	}
	
  // SHOW FIELD-FORM-LIST=====================================================
  
  @GetMapping(path = "/displayForms") 
  public String displayInput(Model model) {
      List<Form> forms = iFormService.getAllForm();
  model.addAttribute("forms", forms); 
  return "/admin/items/formitem"; }
  

  //try this
  
  @RequestMapping("/showData")  
   public String showData(Model model) {
  model.addAttribute("forms", iFormService.getAllForm());
  return"/admin/items/formitem"; }
  
  }
