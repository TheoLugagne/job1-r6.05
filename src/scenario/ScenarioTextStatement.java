package scenario;

import objects.Client;
import objects.Film;
import objects.Location;
import statement.HTMLStatement;
import statement.Statement;
import statement.TextStatement;

public class ScenarioTextStatement extends Scenario {
    @Override
    public String testSituation(String nomClient, String nomFilm, int typeFilm, int nbJours)	{
        Client client = new Client(nomClient);
        Statement statement = new TextStatement();
        Film unFilm = new Film(nomFilm, typeFilm);
        Location uneLocation = new Location(unFilm, nbJours);
        client.addLocation(uneLocation);
        return statement.situation(client);
    }
}
