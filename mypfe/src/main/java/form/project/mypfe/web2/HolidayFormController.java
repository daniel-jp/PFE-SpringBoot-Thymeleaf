package form.project.mypfe.web2;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/formLists")
public class HolidayFormController {
	 @GetMapping(path = "/holidayForm")
	// @ResponseBody
	 public String   holidayForm() {
		 
		 return"/admin/formLists/holidayForm"; 
				 
	 }
		 
}
