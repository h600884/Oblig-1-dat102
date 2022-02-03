package no.hvl.dat102.klient;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;

public class Meny {

private Tekstgrensesnitt tekstgr;  
private FilmarkivADT filmarkiv;  
	  
	 public Meny(FilmarkivADT filmarkiv){ 
	  tekstgr = new Tekstgrensesnitt();  
	  this.filmarkiv = filmarkiv; 
	 } 
	  
	 // legg inn en del forhåndsdefinerte filmer 
	 public void start() { 
		 Film film1 = new Film(1, "George Lucas", "Star Wars: A New Hope", 1977, "LucasFilm", Sjanger.SCIFI);
		 Film film2 = new Film(2, "Jon Watts", "Spider-Man: No Way Home", 2021, "Sony", Sjanger.Action);
		 Film film3 = new Film(3, "Christofer Nolan", "The Dark Knight", 2012, "Warner Bros", Sjanger.Action);
		 Film film4 = new Film(4, "George Lucas" , "Star Wars: Empire strikes back", 1980, "LucasFilm", Sjanger.SCIFI);
		 Film film5 = new Film(5, "Will Gluck", "Friends with benefits", 2011, "Sony", Sjanger.Drama);
		 Film film6 = new Film(6, "Christofer Nolan", "Dunkirk", 2017, "Warner Bros", Sjanger.Historie);
		 
		 filmarkiv.leggTilFilm(film1);
		 filmarkiv.leggTilFilm(film2);
		 filmarkiv.leggTilFilm(film3);
		 filmarkiv.leggTilFilm(film4);
		 filmarkiv.leggTilFilm(film5);
		 filmarkiv.leggTilFilm(film6);

		 tekstgr.visFilm(film1);
		 System.out.println();
		 tekstgr.visFilm(film2);
		 System.out.println();
		 tekstgr.visFilm(film3);
		 System.out.println();
		 tekstgr.visFilm(film4);
		 System.out.println();
		 tekstgr.visFilm(film5);
		 System.out.println();
		 tekstgr.visFilm(film6);
		 System.out.println();
		 
		 tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, "Star Wars");
		 System.out.println();
		 tekstgr.skrivUtFilmProdusent(filmarkiv, "Christofer");
		 System.out.println();
		 tekstgr.skrivUtStatistikk(filmarkiv);

	} 
}
