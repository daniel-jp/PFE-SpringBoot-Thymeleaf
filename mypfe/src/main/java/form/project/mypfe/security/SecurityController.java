package form.project.mypfe.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {


	 @GetMapping(path = "/login")
	    public String login() {
	    
	        return "login";
	    }
	 @GetMapping(path = "/logout")
	    public String logout() {
	    
	        return "login";
	    }
	 
}
