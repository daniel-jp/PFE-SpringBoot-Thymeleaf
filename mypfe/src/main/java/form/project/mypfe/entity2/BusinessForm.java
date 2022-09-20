package form.project.mypfe.entity2;

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
public class BusinessForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String image; 
	private String title; 
	private String phone; 
	private Float price; 
	private String  deliveryAddress;
	private String country;
	private String state;
	private String postCode;
	private String city;
	private String Payment;
}
