package no.hvl.dat102;

public class Film {
	private int filmnr;
	private String produsent;
	private String tittel;
	private int lanseringsdato;
	private String selskap;
	private Sjanger sjanger;
	
	public Film() {
		
	}

	public Film(int filmnr, String produsent, String tittel, int lanseringsdato, String selskap, Sjanger sjanger) {
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.lanseringsdato = lanseringsdato;
		this.selskap = selskap;
		this.sjanger = sjanger;
	}

	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getLanseringsdato() {
		return lanseringsdato;
	}

	public void setLanseringsdato(int lanseringsdato) {
		this.lanseringsdato = lanseringsdato;
	}

	public String getSelskap() {
		return selskap;
	}

	public void setSelskap(String selskap) {
		this.selskap = selskap;
	}
	
	public Sjanger getSjanger() {
		return sjanger;
	}
	
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}
	
	@Override
	public boolean equals(Object film) {
		return(((Film) film).getFilmnr() == filmnr);
	}
	
	@Override
	public int hashCode() { 
	    Integer temp = filmnr; 
	    return temp.hashCode(); 
	} 
}
