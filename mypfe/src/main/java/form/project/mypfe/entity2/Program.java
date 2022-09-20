package form.project.mypfe.entity2;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import form.project.mypfe.enums2.City;
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
@Getter
@Setter
@Data
@Table(name="program")
public class Program {
	@Id
	 @Column(name="uid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String abbreviation;
	private String adress;
	private City city;
	private String description;
	@Temporal(TemporalType.DATE) 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date enddate;
	private String logo;
	private String name;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startdate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
   @JoinColumn(name = "category")
	private Category category; 

}
