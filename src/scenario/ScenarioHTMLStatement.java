package scenario;

import objects.Film;
import objects.Location;
import statement.HTMLStatement;
import statement.Statement;

public class ScenarioHTMLStatement extends Scenario {
    @Override
    public String testSituation(String nomClient, String nomFilm, int typeFilm, int nbJours)	{
        Statement unClient = new HTMLStatement(nomClient);
        Film unFilm = new Film(nomFilm, typeFilm);
        Location uneLocation = new Location(unFilm, nbJours);
        unClient.addLocation(uneLocation);
        return unClient.situation();
    }
}
