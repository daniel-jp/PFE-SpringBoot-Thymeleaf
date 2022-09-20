package form.project.mypfe.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import form.project.mypfe.entity.Task;



@Controller
@RequestMapping("/admin")
public class AdminPageController  {
	


    @GetMapping( { "/dashboard",""})
    public String dashboard(){
        return "/admin/dashboard";
    } 
    
  @GetMapping(path = "/users/userList")
    public String listUser(){ 
        return "/admin/users/user-list";
    } 
	
    @GetMapping(path = "/users/userAdd")
    public String addUser(){ 
        return "/admin/users/user-add";
    } 

    @GetMapping(path = "/programAdd")
    public String addProgram(Model model) { 
    	return "/admin/program-add"; 
    } 
    
 

		/*
		 * @GetMapping("/test") public String test() { return "admin/test"; }
		 */
		
		@GetMapping("/newfile")
		public String newFile() {
			return "admin/fieldform"; 
		}


		/*
		 * @GetMapping("/index") public String main(Model model) {
		 * model.addAttribute("event", new FieldRequest()); return "/admin/index"; }
		

		    @RequestMapping(value = "/save",  params = {"addRow"}, method = RequestMethod.POST)
		    public String save( Model model, @RequestParam("addRow") String addRow,
		    		FieldRequest event,  BindingResult bindingResul) {
		    	if (bindingResul.hasErrors())
		    		return "admin::content";
		    	
		             model.addAttribute("event", event);	      
		      

		    		//return "admin/index::content";
		    	 return "admin/index";
		    }
		     */
		
         @GetMapping(path = "/generatorForm")
		    public String generatorForm() { 
		    
		    	return "/admin/generator-form"; 
		    } 
		    
			@GetMapping(path = "/createForm")
		    public String createForm() {
		    
		        return "/admin/createForm";
		    }
			 
			
		
			@GetMapping(path = "/createtask")
		    public String createTask(Model model) { 
				
				model.addAttribute("task", new Task());
		    
		        return "/admin/task";
		    }
			
			@PostMapping(path = "/savetetask")
		    public String saveTask(Model model, Task task) {
				
				model.addAttribute("task",  task);
				
		        return "/admin/task";
		    }
			 
		 
 
}