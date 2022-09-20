package form.project.mypfe.web2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/formLists")
public class FeedbackFormController {
	
	 @GetMapping(path = "/feedbackForm")
	// @ResponseBody
	 public String  feedbackForm() {
		 
		 return"/admin/formLists/feedbackForm"; 
				 
	 }
}
