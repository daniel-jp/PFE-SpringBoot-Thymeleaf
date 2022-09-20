package form.project.mypfe.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "numerField")
public class NumberField {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")

	private String id; 
    private String name;  
	private String label;
	private Integer max; 
	private Integer min;
	private String value;
	private Long position;

    @Enumerated(EnumType.STRING)
	private Status status;

	@OneToMany(mappedBy = "numerField", cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Form> forms;

}
