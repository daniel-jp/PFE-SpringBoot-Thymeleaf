
  package form.project.mypfe.service;
  
  import java.util.List;

import form.project.mypfe.entity.DateField;
import form.project.mypfe.entity.FieldForm;
import
  form.project.mypfe.entity.Form;
import form.project.mypfe.entity.HeaderField;
import form.project.mypfe.entity.InputField;
  
  
  public interface IFormService {
  
  
  public void initForm(); 
  public Form saveForm(Form form ); 
  public Form updateForm(String id);
  public void deleteForm(String id); 
  public void changePosition(Form form); 
  public List<Form>getAllForm();
  
  
  public void initHeader(); 
  public HeaderField saveHeader(FieldForm fieldForm ); 
  public HeaderField updateHeader(FieldForm fieldForm);
  public void deleteHeade(String id); 
  public void headerPosition(FieldForm fieldForm); 
  public List<HeaderField>getAllHeader();
  
  public void initDate(); 
  public DateField saveDate(FieldForm fieldForm ); 
  public DateField updateDate(String id);
  public void deleteDate(String id); 
  public void datePosition(FieldForm fieldForm); 
  public List<DateField>getAllDate();
  
  public void initInput(); 
  public InputField saveInput(FieldForm fieldForm ); 
  public InputField updateInput(FieldForm fieldForm);
  public void deleteInput(String id); 
  public void inputPosition(FieldForm fieldForm); 
  public List<InputField>getAllInput();
  
	/*
	 * public void initForm(); public Form saveForm (Form form); public Form
	 * updateForm (Long id); public void deleteForm (Long id); public List<Form>
	 * getAllForm ();
	 * 
	 */

  }
  
 