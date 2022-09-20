package form.project.mypfe.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {

	 @JsonProperty("To Do")
	    TODO("To Do"),

	    @JsonProperty("In Progress")
	    IN_PROGRESS("In Progress"),

	    @JsonProperty("Done")
	    DONE("Done");

	    private final String name;

	    Status(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return this.name;
	    }
}
