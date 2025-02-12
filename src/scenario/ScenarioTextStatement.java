package scenario;

import objects.Client;
import objects.Film;
import objects.Location;
import statement.TextStatement;

public class ScenarioTextStatement extends Scenario {
    @Override
    public void testSituation(Client client, String nomFilm, int typeFilm, int nbJours)	{
        TextStatement statement = new TextStatement();
        Film unFilm = new Film(nomFilm, typeFilm);
        Location uneLocation = new Location(unFilm, nbJours);
        client.addLocation(uneLocation);
        statement.situation(client);
    }
}
