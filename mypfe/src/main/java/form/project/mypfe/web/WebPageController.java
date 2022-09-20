package form.project.mypfe.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebPageController {
	
	
	 @GetMapping({"/", "/home","/index"})
	    public String home(){
	        return "home";
	    }

	    @GetMapping("/contact")
	    public String contact(){
	        return "contact";
	    }

	    @GetMapping("/about")
	    public String about(){
	        return "about";
	    }






}
