
package form.project.mypfe.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import form.project.mypfe.enums.Status;
import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data

public class Form {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")

	private String id; 
	private String description;
	private String email;
	private String name;
	private String text;
	private boolean checkbox; 
	private Integer cols;
	private String color; 
	private String label;
	private Integer max; 
	private  Integer maxlength;
	private Integer min;
	private String options;
	private String placeholder;
	private boolean radio;
	private Integer row;
	private String subTitle;
	private String title; 
	private String type;
	private String value;

	@ManyToOne(cascade = CascadeType.ALL)
	private CheckoxField checkoxField;

	@ManyToOne(cascade = CascadeType.ALL)
	private DateField dateField;

	@ManyToOne(cascade = CascadeType.ALL)
	private FileField fileField;

	@ManyToOne(cascade = CascadeType.ALL)
	private HeaderField header;

	@ManyToOne(cascade = CascadeType.ALL)
	private InputField inputField;

	@ManyToOne(cascade = CascadeType.ALL)
	private NumberField numerField;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private RadioField radioField;

	@ManyToOne(cascade = CascadeType.ALL)
	private SelectField selectField;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private TextAreaField textAreaField;

	private Long position;
	
	//@Enumerated(EnumType.STRING)
	private Status status;

	/*
	 * @OneToMany(mappedBy = "form", cascade = CascadeType.ALL, orphanRemoval =
	 * true) private Collection<FieldForm> fieldForms;
	 */

}
