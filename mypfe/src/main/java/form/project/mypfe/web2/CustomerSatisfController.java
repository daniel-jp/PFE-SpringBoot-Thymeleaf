package form.project.mypfe.web2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/formLists")
public class CustomerSatisfController {

	
	
	
	 @GetMapping(path = "/customerSatisf")
	// @ResponseBody
	 public String  customerSatisf() {
		 
		 return"/admin/formLists/customerSatisf";
				 
	 }
		 
}
