package scenario;

import objects.Client;
import objects.Film;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import statement.Statement;
import statement.TextStatement;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ScenarioTextStatementTest {

    private Scenario sc;
    private Statement statement;
    private Client unClient;
    @BeforeEach
    void setUp() {
        this.sc = new ScenarioTextStatement();
        this.statement = new TextStatement();
        this.unClient = new Client("un client");
    }

    @Test
    @DisplayName("test location film normal d'une duree inferieure a 3 jours")
    public void testFilmNormalDureeInf3H(){
        String attendu  = """
                Situation du client: un client
                \tTaxi Driver\t2.0
                Total du 2.0
                Vous gagnez 1 points de fidelite
                """;
        this.sc.testSituation(unClient,"Taxi Driver", Film.NORMAL,2);
        String obtenu = statement.situation(unClient);
        assertEquals(attendu, obtenu);
    }

    @Test
    @DisplayName("test location film normal d'une duree d'au moins 3 jours")
    public void testFilmNormalDuree3J(){
        String attendu  = """
                Situation du client: un client
                \tTaxi Driver\t3.5
                Total du 3.5
                Vous gagnez 1 points de fidelite
                """;
        sc.testSituation(unClient,"Taxi Driver",Film.NORMAL,3);
        String obtenu = statement.situation(unClient);
        assertEquals(attendu, obtenu);
    }

    @Test
    @DisplayName("test location film nouveauté d'une duree inferieure à 2 jours")
    public void testFilmNormalDureeSup2j(){
        String attendu  = """
                Situation du client: un client
                \t11 heures 14\t3.0
                Total du 3.0
                Vous gagnez 1 points de fidelite
                """;

        sc.testSituation(unClient,"11 heures 14",Film.NOUVEAUTE,1);
        String obtenu = statement.situation(unClient);
        assertEquals(attendu, obtenu);
    }

    @Test
    @DisplayName("test location film nouveaute d'une duree d'au moins 2 jours")
    public void testFilmNouveauteDureeInf2j(){
        String attendu  = """
                Situation du client: un client
                \t11 heures 14\t12.0
                Total du 12.0
                Vous gagnez 2 points de fidelite
                """;
        sc.testSituation(unClient,"11 heures 14",Film.NOUVEAUTE,4);
        String obtenu = statement.situation(unClient);
        assertEquals(attendu, obtenu);
    }

    @Test
    @DisplayName("test location film enfant d'une duree inf�rieure a 4 jours")
    public void testFilmNouveauteDureeInf4j(){
        String attendu  = """
                Situation du client: un client
                \tCendrillon\t1.5
                Total du 1.5
                Vous gagnez 1 points de fidelite
                """;
        sc.testSituation(unClient,"Cendrillon",Film.ENFANT,3);
        String obtenu = statement.situation(unClient);
        assertEquals(attendu, obtenu);
    }
    @Test
    @DisplayName("test location film enfant d'une duree d'au moins 4 jours")
    public void testFilmNouveauteDureeSup4j(){
        String attendu  = """
                Situation du client: un client
                \tCendrillon\t3.0
                Total du 3.0
                Vous gagnez 1 points de fidelite
                """;
        sc.testSituation(unClient,"Cendrillon",Film.ENFANT,4);
        String obtenu = statement.situation(unClient);
        assertEquals(attendu, obtenu);
    }

    @Test
    @DisplayName("test location cinephile d'une duréé de 1 jour")
    public void testFilmCinephileDuree1j(){
        String attendu  = """
                Situation du client: un client
                \tTaxi Driver\t2.0
                Total du 2.0
                Vous gagnez 3 points de fidelite
                """;
        sc.testSituation(unClient,"Taxi Driver",Film.CINEPHILE,1);
        String obtenu = statement.situation(unClient);
        assertEquals(attendu, obtenu);
    }

    @Test
    @DisplayName("test location cinephile d'une duréé supérieure à 1 jour")
    public void testFilmCinephileDureeSup1j(){
        String attendu  = """
                Situation du client: un client
                \tTaxi Driver\t6.0
                Total du 6.0
                Vous gagnez 0 points de fidelite
                """;
        sc.testSituation(unClient,"Taxi Driver",Film.CINEPHILE,2);
        String obtenu = statement.situation(unClient);
        assertEquals(attendu, obtenu);
    }

    @Test
    @DisplayName("test location coffret série TV")
    public void testFilmCoffretSerieTV(){
        String attendu  = """
                Situation du client: un client
                \tTaxi Driver\t2.0
                Total du 2.0
                Vous gagnez 0 points de fidelite
                """;
        sc.testSituation(unClient,"Taxi Driver",Film.COFFRET_SERIE_TV,4);
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
        String attendu = """
                Situation du client: client cumul
                \tTaxi Driver\t2.0
                \t11 heures 14\t3.0
                \tCendrillon\t1.5
                Total du 6.5
                Vous gagnez 3 points de fidelite
                """;

        String obtenu = statement.situation(unClient);
        assertEquals(attendu, obtenu);
    }

}

