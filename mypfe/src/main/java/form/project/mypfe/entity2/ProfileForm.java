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
public class ProfileForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

private String image;
private String name;
private String email;
private String sxperience;
private String skills;
private String coment;
private String education;
private String location;
private Boolean agree;

}
