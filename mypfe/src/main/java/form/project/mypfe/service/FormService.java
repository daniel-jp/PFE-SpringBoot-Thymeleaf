
  package form.project.mypfe.service;
  
  import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import
  org.springframework.stereotype.Service;

import form.project.mypfe.dao.DateFieldRepository;
import form.project.mypfe.dao.FormRepository;
import form.project.mypfe.dao.HeaderRepository;
import form.project.mypfe.dao.InputFieldRepository;
import form.project.mypfe.entity.DateField;
import form.project.mypfe.entity.FieldForm;
import form.project.mypfe.entity.Form;
import form.project.mypfe.entity.HeaderField;
import form.project.mypfe.entity.InputField;
import form.project.mypfe.enums.Status;
import
  form.project.mypfe.exception.FieldFormNotFoundException;
import form.project.mypfe.exception.InputNotFoundException;
  
  @Service
  
  @Transactional 
  public class FormService  implements IFormService{
  
  @Autowired private final FormRepository formRepository;
  
  public FormService( FormRepository formRepository) { 
	  this.formRepository =  formRepository; }
  
  @Autowired
  private InputFieldRepository inputFieldRepository;

  @Autowired
  private HeaderRepository headerRepository;

  @Autowired
  private DateFieldRepository dateFieldRepository;


  
  @Override
public List<Form> getAllForm() {
  
  return formRepository.findAll(); }

//Form service------------------------------------------------------------------------
@Override
public void initForm() {

	/*
	 * formRepository.save(new Form()); formRepository.findAll().forEach(cnrstp->{
	 * 
	 * System.out.println("\n");
	 * System.out.println("Abbreviation : "+cnrstp.getAbbreviation());
	 * System.out.println("Adress : "+cnrstp.getAdress());
	 * System.out.println("Description : "+cnrstp.getDescription());
	 * System.out.println("Date : "+cnrstp.getEnddate());
	 * System.out.println("City : "+cnrstp.getCity()); System.out.println("\n");
	 * 
	 * });
	 */
}

@Override
public Form saveForm(Form formRequest) {

	 Form form = new Form();
	 form.setName(formRequest.getName());

	 form.setDescription(formRequest.getDescription());
	 form.setEmail(formRequest.getEmail());
	 form.setText(formRequest.getText());
	 form.setTitle(formRequest.getTitle());
	 form.setValue(formRequest.getValue());
	 form.setCheckoxField(formRequest.getCheckoxField());
	 form.setName(formRequest.getName());
	 form.setInputField(formRequest.getInputField());
	 form.setStatus(Status.TODO);
	 form.setPosition(formRepository.countFormByStatus(Status.TODO));
 
	return formRepository.save(form); 
}

@Override
public Form updateForm(String id) {
	 Form form = formRepository.findById(id).orElseThrow( FieldFormNotFoundException::new);
	 form.setStatus(Status.TODO);
	 form.setPosition(formRepository.countFormByStatus(Status.TODO));

	return formRepository.save(form);
}

@Override
public void deleteForm(String id) {

Form form = formRepository.getById(id);
formRepository.decrementBelow(form.getPosition(),
form.getStatus(), form.getId());
formRepository.deleteById(id);

}

@Override
public void changePosition(Form formRequest) {
	 Form form =  formRepository.findById(formRequest.getId()).orElseThrow(
			  FieldFormNotFoundException::new);
			  
			  Long oldPosition = form.getPosition(); 
			  Long newPosition = form.getPosition(); 
			  Status oldStatus = form.getStatus();
			  
			  if (oldStatus.equals(formRequest.getStatus())) { if (newPosition >
			  oldPosition) {
			  
			  formRepository.decrementAboveToPosition(newPosition, oldPosition,
			  oldStatus, form.getId());
			  
			  } else { formRepository.incrementBelowToPosition(newPosition,
			  oldPosition, oldStatus, form.getId()); }
			  
			  form.setPosition(formRequest.getPosition());
			  formRepository.save(form); } else { Status newStatus =
					  formRequest.getStatus();
			  
			  formRepository.decrementBelow(form.getPosition(), oldStatus,
			  form.getId());
			  formRepository.incrementBelow(formRequest.getPosition(), newStatus,
			  form.getId());
			  
			  form.setPosition(formRequest.getPosition());
			  form.setStatus(formRequest.getStatus());
			  formRepository.save(form); } 
	
}

 

//Header service------------------------------------------------------------------------

@Override
public void initHeader() {
	// TODO Auto-generated method stub
	
}

@Override
public HeaderField saveHeader(FieldForm fieldForm) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public HeaderField updateHeader(FieldForm fieldForm) {
	HeaderField headerField = headerRepository.findById(fieldForm.getId())
            .orElseThrow(InputNotFoundException::new);
	return headerRepository.save(headerField);
	 
}

@Override
public void deleteHeade(String id) {
	HeaderField headerField = headerRepository.getById(id);
	headerRepository.decrementBelow(headerField.getPosition(),
			headerField.getStatus(), headerField.getId());
	headerRepository.deleteById(id);
}

@Override
public void headerPosition(FieldForm fieldForm) {
	HeaderField headerField =  headerRepository.findById(fieldForm.getId()).orElseThrow(
			  FieldFormNotFoundException::new);
			  
			  Long oldPosition = headerField.getPosition(); 
			  Long newPosition = headerField.getPosition(); 
			  Status oldStatus = headerField.getStatus();
			  
			  if (oldStatus.equals(fieldForm.getStatus())) { if (newPosition >
			  oldPosition) {
			  
				  headerRepository.decrementAboveToPosition(newPosition, oldPosition,
			  oldStatus, headerField.getId());
			  
			  } else { headerRepository.incrementBelowToPosition(newPosition,
			  oldPosition, oldStatus, headerField.getId()); }
			  
			  headerField.setPosition(fieldForm.getPosition());
			  headerRepository.save(headerField); } else { Status newStatus =
					  fieldForm.getStatus();
			  
			  headerRepository.decrementBelow(headerField.getPosition(), oldStatus,
					  headerField.getId());
			  headerRepository.incrementBelow(fieldForm.getPosition(), newStatus,
					  headerField.getId());
			  
			  headerField.setPosition(fieldForm.getPosition());
			  headerField.setStatus(fieldForm.getStatus());
			  headerRepository.save(headerField); } 
	
}

@Override
public List<HeaderField> getAllHeader() {
	// TODO Auto-generated method stub
	 return headerRepository.findAll();
}



//Date service------------------------------------------------------------------------

@Override
public void initDate() {
	// TODO Auto-generated method stub
	
}

@Override
public DateField saveDate(FieldForm fieldForm) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public DateField updateDate(String id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void deleteDate(String id) {
	// TODO Auto-generated method stub
	
}

@Override
public void datePosition(FieldForm fieldForm) {
	// TODO Auto-generated method stub
	
}

@Override
public List<DateField> getAllDate() {
	// TODO Auto-generated method stub
	return null;
}




//Input service------------------------------------------------------------------------

@Override
public void initInput() {
	inputFieldRepository.save(new InputField());
	  
	inputFieldRepository.findAll().forEach(input-> {
		  System.out.println("\n");
	      System.out.println("Form -------------|\n");
	      System.out.println("Label : " + input.getLabel());
	      System.out.println("Name : " + input.getName());
	      System.out.println("Placholder : " + input.getPlaceholder());
	      System.out.println("Type : " + input.getType());
	      System.out.println("Value : " + input.getValue());

	      System.out.println("Status : " + input.getStatus());
	      System.out.println("Position : " + input.getPosition());

	      System.out.println("\n"); 
	  });
	  
}

@Override
public InputField saveInput(FieldForm fieldForm) {
	InputField inputField = new InputField();
	inputField.setLabel(fieldForm.getLabel());
	inputField.setName(fieldForm.getName());
	inputField.setPlaceholder(fieldForm.getPlaceholder());
	inputField.setStatus(Status.TODO);
    inputField.setPosition(inputFieldRepository.countFormByStatus(Status.TODO));
	inputField.setType(fieldForm.getType());
	inputField.setValue(fieldForm.getValue());
    return inputFieldRepository.save(inputField);

}

@Override
public InputField updateInput(FieldForm fieldForm) {
	InputField input = inputFieldRepository.findById(fieldForm.getId())
            .orElseThrow(InputNotFoundException::new);
	
input.setLabel(fieldForm.getLabel());
input.setName(fieldForm.getName());
input.setPlaceholder(fieldForm.getPlaceholder());
input.setType(fieldForm.getType());
input.setValue(fieldForm.getValue());

return inputFieldRepository.save(input);
}

@Override
public void deleteInput(String id) {
	  InputField input = inputFieldRepository.findById(id).orElseThrow(InputNotFoundException::new);
      inputFieldRepository.decrementBelow(input.getPosition(),input.getStatus(), input.getId());
      inputFieldRepository.deleteById(id);	
}

@Override
public void inputPosition(FieldForm fieldForm) {
	InputField input = inputFieldRepository.findById(fieldForm.getId())
            .orElseThrow(InputNotFoundException::new);

Long oldPosition = input.getPosition();
Long newPosition = fieldForm.getPosition();
Status oldStatus = input.getStatus();

if (oldStatus.equals(fieldForm.getStatus())) {
if (newPosition > oldPosition) {
inputFieldRepository.decrementAboveToPosition(newPosition, oldPosition, oldStatus, input.getId());
} else {
inputFieldRepository.incrementBelowToPosition(newPosition, oldPosition, oldStatus, input.getId());
}

input.setPosition(fieldForm.getPosition());
inputFieldRepository.save(input);
} else {
Status newStatus = fieldForm.getStatus();

inputFieldRepository.decrementBelow(input.getPosition(), oldStatus, input.getId());
inputFieldRepository.incrementBelow(fieldForm.getPosition(), newStatus, input.getId());

input.setPosition(fieldForm.getPosition());
input.setStatus(fieldForm.getStatus());
inputFieldRepository.save(input);
}
}

@Override
public List<InputField> getAllInput() {
	   return inputFieldRepository.findAll();
}






  }
 