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
public class ProjectForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
   private String projectDescription;
	private String descriptionEntreprise;
	private String hébergement;
	private String domaine;
	private String webBut;
	private String cible;
	private String concurrents;
	private String différencie;
	private String langues;
	private String menu;
	private String contenu;
	private String choisissent;
	private String genreImage;
	private String visiter;
	private String commentaires;
}
