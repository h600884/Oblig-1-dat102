package no.hvl.dat102.klient;

import java.util.*;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;

public class Tekstgrensesnitt {

	 // lese opplysningene om en FILM fra tastatur  
	 public Film lesFilm() { 
	Film film = null;
	Scanner tast = new Scanner(System.in);
	
	System.out.println("Filmnummer:");
	int filmnr = tast.nextInt();
	
	tast.nextLine();
	
	System.out.println("Film produsent:");
	String produsent = tast.nextLine();
	
	System.out.println("Film tittel:");
	String tittel = tast.nextLine();
	
	System.out.println("Lanseringsår:");
	int lanseringsdato = tast.nextInt();
	
	tast.nextLine();
		
	System.out.println("Film selskap:");
	String selskap = tast.nextLine();
	
	System.out.println("Film sjanger:");
	Sjanger sjanger = Sjanger.valueOf(tast.nextLine());
	tast.nextLine();
//	Sjanger.ACTION.toString();
//	Sjanger.DRAMA.toString();
//	Sjanger.HISTORY.toString();
//	Sjanger.SCIFI.toString();
////	String s = " ";
////	Sjanger sjanger = Sjanger.valueOf(s);
////	s = tast.next();
//	tast.nextLine();
	
	 
	film = new Film(filmnr, produsent, tittel, lanseringsdato,selskap, sjanger);
	tast.close();
	
	
	return film;
	 } 
	 
	 // vise en film med alle opplysninger på skjerm (husk tekst for sjanger) 
	 public void visFilm(Film film) { 
	System.out.println("Film nummer: " + film.getFilmnr() + "\nFilm produsent: " + film.getProdusent() + "\nFilm tittel: " + film.getTittel() + "\nLanseringsår: " + film.getLanseringsdato() + "\nFilm selskap: " + film.getSelskap() + "\nFilm sjanger: " + film.getSjanger());	 
	 } 
	 
	 // Skrive ut alle Filmer med en spesiell delstreng i tittelen 
	 public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) { 
		 Film[] nyFilmTab = filma.soekTittel(delstreng);
		 for(Film f: nyFilmTab) {
			 if(f != null) {
				 visFilm(f);
			 }
		 }
	  
	 } 
	 
	 // Skriver ut alle Filmer av en produsent / en gruppe 
	 public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) { 
		 Film[] nyFilmtab = new Film[filma.antall()+1];
		 for(int i = 1; i < nyFilmtab.length; i++) {
			 if(filma.finnFilm(i).getProdusent().contains(delstreng)) {
				 nyFilmtab[i] = filma.finnFilm(i);
			 }
		 }
		 for(Film f : nyFilmtab) {
			 if(f != null) {
				 visFilm(f);
			 }
		 }
	 } 
	 
	 // Skrive ut en enkel statistikk som inneholder antall Filmer totalt 
	 // og hvor mange det er i hver sjanger 
	 public void skrivUtStatistikk(FilmarkivADT filma) { 
		 System.out.println("Antall filmer: " + filma.antall());
		 System.out.println("Antall Action filmer: " + filma.antall(Sjanger.Action));
		 System.out.println("Antall Drama filmer: " + filma.antall(Sjanger.Drama));
		 System.out.println("Antall Historie filmer: " + filma.antall(Sjanger.Historie));
		 System.out.println("Antall SCIFI filmer: " + filma.antall(Sjanger.SCIFI));
	 } 

}
