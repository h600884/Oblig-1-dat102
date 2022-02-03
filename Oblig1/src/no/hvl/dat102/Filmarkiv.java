package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

private int antall;
private Film[] tab;


	public Filmarkiv(int antall) {
		tab = new Film[antall];
//		antall = 0;
	}
	
	private void utvid() {
		Film[] nyTab = new Film[antall * 2];
		for(int i = 0; i < tab.length; i++)
		{
			nyTab[i] = tab[i];
		}
		tab = nyTab;
	}
	

	@Override
	public  Film finnFilm(int nr) {
		for(int i = 0; i < tab.length; i++) {
			if(tab[i].getFilmnr() == nr) {
				return tab[i];
			} 
		}
		return null;
	}
//	@Override
//	public void visFilm(int nr) {
//		for(int i = 0; i < tab.length; i++) {
//			if(tab[i].getFilmnr() == nr) {
//				System.out.println(tab[i]);
//			} else {
//				System.out.println("Fant ikke film");
//			}
//		}
//	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if(antall == tab.length) {
			utvid();
		} else {
			tab[antall] = nyFilm;
			antall++;
		}
	}

	@Override
	public boolean slettFilm(int filmnr) {
		boolean funnet = false;
		for(int i = 0; (i < antall && !funnet); i++) {
			if(tab[i].getFilmnr() == filmnr) {
				tab[i] = tab[antall-1];
				tab[antall-1] = null;
				antall--;
				funnet = true;
			}
		}
		return funnet;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] nyFilm = new Film[antall];
		for(int i = 0; i < antall; i++) {
			if(tab[i].getTittel().contains(delstreng)) {
			nyFilm[i] = tab[i];
			}
		}
		return nyFilm;
	}

	@Override 
	public int antall(Sjanger sjanger) {
		int antMedSjanger = 0;
		for(int i = 0; i < antall; i++) {
			if(tab[i].getSjanger().equals(sjanger)) {
				antMedSjanger++;
			}
		}
		return antMedSjanger;
	}

	@Override
	public int antall() {
		return antall;
	}
	
	
}
