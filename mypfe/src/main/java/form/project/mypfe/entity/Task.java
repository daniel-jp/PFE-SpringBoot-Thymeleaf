package form.project.mypfe.entity;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data

public class Task {

	private Long id;
	private String title;

	private String text;

}
