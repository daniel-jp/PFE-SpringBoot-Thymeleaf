package form.project.mypfe.web2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/formLists")
public class TemplateController {
	
	 @GetMapping(path = "/templates-list")
		public String addTemmplats() {
			
			  return "admin/formLists/templates-list"; 
		}
	 
	 
	 
		@GetMapping(path = "/inProgress")
	    public String inProgress() {
	    
	        return "/admin/formLists/inProgress";
	    }
		
		 
		@GetMapping(path = "/templateDisplayList/showtemplatesList")
	    public String ShowtemplatesList() {
	    
	        return "/admin/formLists/templateDisplayList/showtemplatesList";
	    }
	 
	 
		
} 
