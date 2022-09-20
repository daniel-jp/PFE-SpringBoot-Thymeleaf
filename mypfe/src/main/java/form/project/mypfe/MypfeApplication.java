package form.project.mypfe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import form.project.mypfe.service.ITemplatesService;

@SpringBootApplication
public class MypfeApplication implements CommandLineRunner {
	
    @Autowired  private ITemplatesService iTemplatesService;
 //   @Autowired  private  IFieldFormService iFieldFormService;
    
    
    
	public static void main(String[] args) {
		SpringApplication.run(MypfeApplication.class, args);
		
	} 

	@Override
	public void run(String... args) throws Exception {
	 // TODO Auto-gene rated method stub
		
	//	  iFieldItemsFormService.initFieldItemsForm();
	//	iFieldFormService.initForm();
		/// ALOT OF FORMS 
		
		iTemplatesService.initCategory();
		iTemplatesService.initProgram();
	
  
	}
}
 