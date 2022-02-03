package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT{
 private int antall; 	
 private LinearNode<Film> start; 
 
 	public Filmarkiv2() {
 		start = new LinearNode<>();
 		antall = 0;
 	}
 
	@Override
	public Film finnFilm(int nr) {
		LinearNode<Film> node = start;
		for(int i = 0; i < antall; i++) {
			if(node.getElement().getFilmnr() == nr) {
				return node.getElement();
			}
			node = node.getNeste();
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
		nyNode.setNeste(nyNode);
		start = nyNode;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		LinearNode<Film> node1 = start;
		LinearNode<Film> node2 = node1.getNeste();
		for(int i = 0; i < antall; i++) {
			if(node1.getElement().getFilmnr() == filmnr) {
				node1.setElement(node2.getElement());
				node1.setNeste(node2.getNeste());
				antall--;
				return true;
			} else {
				node1.setElement(node2.getElement());
				node1.setNeste(node2.getNeste());
			}
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		int ant = 0;
		LinearNode<Film> node = start;
		Film[] tab = new Film[antall];
		
		for(int i = 0; i < antall; i++) {
			if(node.getElement().getTittel().equals(delstreng)) {
				tab[ant] = node.getElement();
				ant++;
			}
			node = node.getNeste();
		}
		return tab;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int ant = 0; 
		LinearNode<Film> node = start;
		
		while(node != null) {
			if(node.getElement().getSjanger().equals(sjanger)) {
				ant++;
			}
			node = node.getNeste();
		}
		return ant;
	}

	@Override
	public int antall() {
		return antall;
	}

}
