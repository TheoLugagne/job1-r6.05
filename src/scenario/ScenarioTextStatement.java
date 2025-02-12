package scenario;

import objects.Film;
import objects.Location;
import statement.Statement;
import statement.TextStatement;

public class ScenarioTextStatement extends Scenario {
    @Override
    public String testSituation(String nomClient, String nomFilm, int typeFilm, int nbJours)	{
        Statement unClient = new TextStatement(nomClient);
        Film unFilm = new Film(nomFilm, typeFilm);
        Location uneLocation = new Location(unFilm, nbJours);
        unClient.addLocation(uneLocation);
        return unClient.situation();
    }
}
