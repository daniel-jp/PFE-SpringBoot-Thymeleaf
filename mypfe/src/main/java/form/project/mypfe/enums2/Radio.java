package form.project.mypfe.enums2;

public enum Radio {
	Weak("Weak"),
	Notbad("Not bad"),
	Mean("Mean"),
	Pleasant("Pleasant"),
	 Nice("Nice"),
	 Excellent("Excellent");
	
	private String alllever;
	Radio(String alllever) {
		this.alllever= alllever;;
	}
	public String getAlllever() { 
		return alllever;
	}
	public void setAlllever(String alllever) {
		this.alllever = alllever;
	} 
	
}