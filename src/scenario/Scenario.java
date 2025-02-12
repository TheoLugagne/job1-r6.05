package scenario;

import objects.Client;
import objects.Film;
import objects.Location;

public abstract class Scenario {
	
	public  abstract void testSituation(Client client, String nomFilm, int typeFilm, int nbJours );

	
	public void testSituationCumul(Client unClient, String nomFilm, int typeFilm, int nbJours) {
		Film unFilm = new Film(nomFilm, typeFilm);
		Location uneLocation = new Location(unFilm, nbJours);
		unClient.addLocation(uneLocation);
	}
}