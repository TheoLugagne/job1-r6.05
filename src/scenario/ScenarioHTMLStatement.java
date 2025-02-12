package scenario;

import objects.Client;
import objects.Film;
import objects.Location;
import statement.HTMLStatement;
import statement.Statement;

public class ScenarioHTMLStatement extends Scenario {
    @Override
    public String testSituation(Client client, String nomFilm, int typeFilm, int nbJours)	{
        Statement statement = new HTMLStatement();
        Film unFilm = new Film(nomFilm, typeFilm);
        Location uneLocation = new Location(unFilm, nbJours);
        client.addLocation(uneLocation);
        return statement.situation(client);
    }
}
