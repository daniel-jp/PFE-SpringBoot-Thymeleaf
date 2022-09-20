package form.project.mypfe.entity2;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class HolidayForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String lastname;
	private String firstname;
	private String directFname;
	private String directLname;
	private Boolean departement =true;
	private String raison;
	private Boolean duratLeave =true;
	private Date dateSt; 
	private Date dateEnd; 
	private Boolean conditions =true;
	
}
