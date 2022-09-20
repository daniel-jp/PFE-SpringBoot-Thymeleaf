package form.project.mypfe.entity2;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ToString
@Entity
@NoArgsConstructor 
@AllArgsConstructor 
@Setter
@Getter
@Data
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
    @Column(name = "name", nullable = false)
	private String name;
	@OneToMany(mappedBy = "category",  cascade = CascadeType.REFRESH, orphanRemoval = true, fetch = FetchType.EAGER)
	//@JsonIgnore
	private Collection<Program> programs;
	

} 
