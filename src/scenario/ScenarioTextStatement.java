package scenario;

import objects.Client;
import objects.Film;
import objects.Location;
import statement.HTMLStatement;
import statement.Statement;
import statement.TextStatement;

public class ScenarioTextStatement extends Scenario {
    @Override
    public String testSituation(Client client, String nomFilm, int typeFilm, int nbJours)	{
        Statement statement = new TextStatement();
        Film unFilm = new Film(nomFilm, typeFilm);
        Location uneLocation = new Location(unFilm, nbJours);
        client.addLocation(uneLocation);
        return statement.situation(client);
    }
}
