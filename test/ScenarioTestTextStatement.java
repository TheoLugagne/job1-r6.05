import objects.Client;
import objects.Film;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import scenario.Scenario;
import scenario.ScenarioTextStatement;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ScenarioTestTextStatement {

    private Scenario sc;
    @BeforeEach
    void setUp() {
        this.sc = new ScenarioTextStatement();
    }

    @Test
    @DisplayName("test location film normal d'une duree inferieure a 3 jours")
    public void testFilmNormalDureeInf3H(){
        String attendu  = "Situation du client: un client\n"
                + "\tTaxi Driver\t2.0\n"
                + "Total du 2.0\n"
                + "Vous gagnez 1 points de fidelite\n";

        String obtenu = this.sc.testSituation("un client","Taxi Driver", Film.NORMAL,2);
        assertEquals(attendu, obtenu);
    }

    @Test
    @DisplayName("test location film normal d'une duree d'au moins 3 jours")
    public void testFilmNormalDuree3J(){
        String attendu  = "Situation du client: un client\n"
                + "\tTaxi Driver\t3.5\n"
                + "Total du 3.5\n"
                + "Vous gagnez 1 points de fidelite\n";

        String obtenu = sc.testSituation("un client","Taxi Driver",Film.NORMAL,3);
        assertEquals(attendu, obtenu);
    }

    @Test
    @DisplayName("test location film nouveauté d'une duree inferieure à 2 jours")
    public void testFilmNormalDureeSup2j(){
        String attendu  = "Situation du client: un client\n"
                + "\t11 heures 14\t3.0\n"
                + "Total du 3.0\n"
                + "Vous gagnez 1 points de fidelite\n";

        String obtenu = sc.testSituation("un client","11 heures 14",Film.NOUVEAUTE,1);
        assertEquals(attendu, obtenu);
    }

    @Test
    @DisplayName("test location film nouveaute d'une duree d'au moins 2 jours")
    public void testFilmNouveauteDureeInf2j(){
        String attendu  = "Situation du client: un client\n"
                + "\t11 heures 14\t12.0\n"
                + "Total du 12.0\n"
                + "Vous gagnez 2 points de fidelite\n";

        String obtenu = sc.testSituation("un client","11 heures 14",Film.NOUVEAUTE,4);
        assertEquals(attendu, obtenu);
    }

    @Test
    @DisplayName("test location film enfant d'une duree inf�rieure a 4 jours")
    public void testFilmNouveauteDureeInf4j(){
        String attendu  = "Situation du client: un client\n"
                + "\tCendrillon\t1.5\n"
                + "Total du 1.5\n"
                + "Vous gagnez 1 points de fidelite\n";

        String obtenu = sc.testSituation("un client","Cendrillon",Film.ENFANT,3);
        assertEquals(attendu, obtenu);
    }
    @Test
    @DisplayName("test location film enfant d'une duree d'au moins 4 jours")
    public void testFilmNouveauteDureeSup4j(){
        String attendu  = "Situation du client: un client\n"
                + "\tCendrillon\t3.0\n"
                + "Total du 3.0\n"
                + "Vous gagnez 1 points de fidelite\n";

        String obtenu = sc.testSituation("un client","Cendrillon",Film.ENFANT,4);
        assertEquals(attendu, obtenu);
    }
    @Test
    @DisplayName("client cumul")
    public void testSituationCumul(){
        Client unClient = new Client("client cumul");
        sc.testSituationCumul(unClient,"Taxi Driver",Film.NORMAL,2);
        sc.testSituationCumul(unClient,"11 heures 14",Film.NOUVEAUTE,1);
        sc.testSituationCumul(unClient,"Cendrillon",Film.ENFANT,2);
        String attendu = "Situation du client: client cumul\n"
                + "\tTaxi Driver\t2.0\n"
                + "\t11 heures 14\t3.0\n"
                + "\tCendrillon\t1.5\n"
                + "Total du 6.5\n"
                + "Vous gagnez 3 points de fidelite\n";

        String obtenu = unClient.situation();
        assertEquals(attendu, obtenu);
    }

}

