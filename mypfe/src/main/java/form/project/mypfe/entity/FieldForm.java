package form.project.mypfe.entity;

import form.project.mypfe.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@NoArgsConstructor
@AllArgsConstructor 
@Setter
@Getter 
@Data 


public class FieldForm {

	private String id;

	private boolean checkbox; 
	private Integer cols;
	private String color; 
	private  String description; 
    private String name;  
	private String label;
	private Integer max; 
	private  Integer maxlength;
	private Integer min;
	private String options;
	private String placeholder;
	private Long position;
	private boolean radio;
	private Integer row;
	private String subTitle;
	private String title; 
	private String type;
	private String value;
	private Status status;
					

 

}
