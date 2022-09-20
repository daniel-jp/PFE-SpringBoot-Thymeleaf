package form.project.mypfe.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter

public enum InputStatus {
	

	 @JsonProperty("To Do")
	    TODO("To Do"),

	    @JsonProperty("In Progress")
	    IN_PROGRESS("In Progress"),

	    @JsonProperty("Done")
	    DONE("Done");

	    private final String value;
	
		
		
	  
}
