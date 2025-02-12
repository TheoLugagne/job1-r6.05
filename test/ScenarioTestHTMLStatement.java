import objects.Client;
import objects.Film;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import scenario.Scenario;
import scenario.ScenarioHTMLStatement;
import statement.HTMLStatement;
import statement.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

//TODO faire passer ces tests avec le bon code HTML
//FIX impossible de formater le toString ee film car pas absract
class ScenarioTestHTMLStatement {

    private Scenario sc;
    private Statement statement;
    private Client unClient;
    @BeforeEach
    void setUp() {
        this.sc = new ScenarioHTMLStatement();
        this.statement = new HTMLStatement();
        this.unClient = new Client("un client");
    }

    @Test
    @DisplayName("test location film normal d'une duree inferieure a 3 jours")
    public void testFilmNormalDureeInf3H(){
String attendu  = "<p>Situation du client: un client</p>\n"
                + "<p>\tTaxi Driver\t2.0\n</p>\n"
                + "<p>Total du 2.0</p>\n"
                + "<p>Vous gagnez 1 points de fidélité</p>\n";

        this.sc.testSituation(unClient,"Taxi Driver",Film.NORMAL,2);
        String obtenu = statement.situation(unClient);

        assertEquals(attendu, obtenu);
    }

    @Test
    @DisplayName("test location film normal d'une duree d'au moins 3 jours")
    public void testFilmNormalDuree3J(){
String attendu  = "<p>Situation du client: un client</p>\n"
                + "<p>\tTaxi Driver\t3.5\n</p>\n"
                + "<p>Total du 3.5</p>\n"
                + "<p>Vous gagnez 1 points de fidélité</p>\n";
        sc.testSituation(unClient,"Taxi Driver",Film.NORMAL,3);
        String obtenu = statement.situation(unClient);
        assertEquals(attendu, obtenu);
    }

    @Test
    @DisplayName("test location film nouveauté d'une duree inferieure à 2 jours")
    public void testFilmNormalDureeSup2j(){
String attendu  = "<p>Situation du client: un client</p>\n"
                + "<p>\t11 heures 14\t3.0\n</p>\n"
                + "<p>Total du 3.0</p>\n"
                + "<p>Vous gagnez 1 points de fidélité</p>\n";
        sc.testSituation(unClient,"11 heures 14", Film.NOUVEAUTE,1);
        String obtenu = statement.situation(unClient);
        assertEquals(attendu, obtenu);
    }

    @Test
    @DisplayName("test location film nouveaute d'une duree d'au moins 2 jours")
    public void testFilmNouveauteDureeInf2j(){
String attendu  = "<p>Situation du client: un client</p>\n"
                + "<p>\t11 heures 14\t12.0\n</p>\n"
                + "<p>Total du 12.0</p>\n"
                + "<p>Vous gagnez 2 points de fidélité</p>\n";
        sc.testSituation(unClient,"11 heures 14",Film.NOUVEAUTE,4);
        String obtenu = statement.situation(unClient);
        assertEquals(attendu, obtenu);
    }

    @Test
    @DisplayName("test location film enfant d'une duree inf�rieure a 4 jours")
    public void testFilmNouveauteDureeInf4j(){
String attendu  = "<p>Situation du client: un client</p>\n"
                + "<p>\tCendrillon\t1.5\n</p>\n"
                + "<p>Total du 1.5</p>\n"
                + "<p>Vous gagnez 1 points de fidélité</p>\n";
        sc.testSituation(unClient,"Cendrillon",Film.ENFANT,3);
        String obtenu = statement.situation(unClient);
        assertEquals(attendu, obtenu);
    }
    @Test
    @DisplayName("test location film enfant d'une duree d'au moins 4 jours")
    public void testFilmNouveauteDureeSup4j(){
String attendu  = "<p>Situation du client: un client</p>\n"
                + "<p>\tCendrillon\t3.0\n</p>\n"
                + "<p>Total du 3.0</p>\n"
                + "<p>Vous gagnez 1 points de fidélité</p>\n";
        sc.testSituation(unClient,"Cendrillon",Film.ENFANT,4);
        String obtenu = statement.situation(unClient);
        assertEquals(attendu, obtenu);
    }
    @Test
    @DisplayName("client cumul")
    public void testSituationCumul(){
        Client unClient = new Client("client cumul");

        sc.testSituationCumul(unClient,"Taxi Driver",Film.NORMAL,2);
        sc.testSituationCumul(unClient,"11 heures 14",Film.NOUVEAUTE,1);
        sc.testSituationCumul(unClient,"Cendrillon",Film.ENFANT,2);
        Statement statement = new HTMLStatement();
        String attendu = "<p>Situation du client: client cumul</p>\n"
                + "<p>\tTaxi Driver\t2.0\n"
                + "\t11 heures 14\t3.0\n"
                + "\tCendrillon\t1.5\n</p>\n"
                + "<p>Total du 6.5</p>\n"
                + "<p>Vous gagnez 3 points de fidélité</p>\n";

        String obtenu = statement.situation(unClient);
        assertEquals(attendu, obtenu);
    }

}

