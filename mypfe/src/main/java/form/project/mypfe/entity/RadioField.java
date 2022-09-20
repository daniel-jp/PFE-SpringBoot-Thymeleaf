package form.project.mypfe.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "radioField")
public class RadioField {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	

    private String name;  
	private String label;
	private String options;
	private Long position;

	// @Enumerated(EnumType.STRING)
	private Status status;
	private boolean radio;
	private String value;
					
	
	
	@OneToMany(mappedBy = "radioField", cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Form> forms;

}
