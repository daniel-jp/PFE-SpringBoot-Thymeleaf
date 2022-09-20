package form.project.mypfe.enums2;

public enum City {
	
	Agadir("Agadir"),
	Azrou ("Azrou"),
	Aklim ("Aklim"),
	Ahfir ("Ahfir"),
	AinDorij ("Ain Dorij"),
	AinJemaa ("Ain Jemaa"),
	BeniChiker ("Beni Chiker"),
	BeniAnsar ("Beni Ansar"),
	BeniMellal ("Beni Mellal"),
	BenSlimane ("Ben Slimane"), 
	Casablanca ("Casablanca"),
	Chalwa ("Chalwa"),
	Dakhla ("Dakhla"),
	DouarBel("Douar Bel"),
	Driouch ("Driouch"),
	Debdou ("Debdou"),
	Fes ("Fes"),
	Marrakech ("Marrakech"), 
	Martil ("Martil"),
	ElJadida ("El Jadida"),
	Oujda ("Oujda"),
	Tetouan ("Tetouan"),
	Tanger ("Tanger"),
	Mohamedia ("Mohamedia"),
	Kenitra ("Kenitra"),
	Rabat ("Rabat"),
	Sale ("Sale");
	
	public String vile;

	City(String vile) {
		this.vile= vile;
	} 

	public String getVile() {
		return vile;
	}

	public void setVile(String vile) {
		this.vile = vile;
	}

	
	
}
