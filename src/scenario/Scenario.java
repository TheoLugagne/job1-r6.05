package scenario;

import objects.Client;
import objects.Film;
import objects.Location;

public abstract class Scenario {
	
	public  abstract String testSituation(Client client, String nomFilm, int typeFilm, int nbJours );

	
	public void testSituationCumul(Client unClient, String nomFilm, int typeFilm, int nbJours) {
		Film unFilm = new Film(nomFilm, typeFilm);
		Location uneLocation = new Location(unFilm, nbJours);
		unClient.addLocation(uneLocation);
	}
	
	/*public static void main(String[] args) {
		scenario.Scenario sc = new scenario.Scenario();
		System.out.println("Coucou, c'est les tests qui commencent");

		// test location film normal d'une duree inferieure a 3 jours
		String attendu  = "Situation du client: un client\n"
						+ "\tTaxi Driver\t2.0\n"
						+ "Total du 2.0\n"
						+ "Vous gagnez 1 points de fidelite\n";
		String obtenu = sc.testSituation("un client","Taxi Driver",objects.Film.NORMAL,2);
		if (! attendu.equals(obtenu))
			System.out.println(attendu + obtenu);

		// test location film normal d'une duree d'au moins 3 jours
		attendu  = "Situation du client: un client\n"
			+ "\tTaxi Driver\t3.5\n"
			+ "Total du 3.5\n"
			+ "Vous gagnez 1 points de fidelite\n";
		obtenu = sc.testSituation("un client","Taxi Driver",objects.Film.NORMAL,3);
		if (! attendu.equals(obtenu))
			System.out.println(attendu + obtenu);

		// test location film nouveauté d'une duree inferieure à 2 jours
		attendu  = "Situation du client: un client\n"
			+ "\t11 heures 14\t3.0\n"
			+ "Total du 3.0\n"
			+ "Vous gagnez 1 points de fidelite\n";
		obtenu = sc.testSituation("un client","11 heures 14",objects.Film.NOUVEAUTE,1);
		if (! attendu.equals(obtenu))
			System.out.println(attendu + obtenu);

		// test location film nouveaute d'une duree d'au moins 2 jours
		attendu  = "Situation du client: un client\n"
			+ "\t11 heures 14\t12.0\n"
			+ "Total du 12.0\n"
			+ "Vous gagnez 2 points de fidelite\n";
		obtenu = sc.testSituation("un client","11 heures 14",objects.Film.NOUVEAUTE,4);
		if (! attendu.equals(obtenu))
			System.out.println(attendu + obtenu);

		// test location film enfant d'une duree inf�rieure a 4 jours
		attendu  = "Situation du client: un client\n"
			+ "\tCendrillon\t1.5\n"
			+ "Total du 1.5\n"
			+ "Vous gagnez 1 points de fidelite\n";
		obtenu = sc.testSituation("un client","Cendrillon",objects.Film.ENFANT,3);
		if (! attendu.equals(obtenu))
			System.out.println(attendu + obtenu);

		// test location film enfant d'une duree d'au moins 4 jours
		attendu  = "Situation du client: un client\n"
			+ "\tCendrillon\t3.0\n"
			+ "Total du 3.0\n"
			+ "Vous gagnez 1 points de fidelite\n";
		obtenu = sc.testSituation("un client","Cendrillon",objects.Film.ENFANT,4);
		if (! attendu.equals(obtenu))
			System.out.println(attendu + obtenu);

		// test cumul
		objects.Client unClient = new objects.Client("client cumul");
		sc.testSituationCumul(unClient,"Taxi Driver",objects.Film.NORMAL,2);
		sc.testSituationCumul(unClient,"11 heures 14",objects.Film.NOUVEAUTE,1);
		sc.testSituationCumul(unClient,"Cendrillon",objects.Film.ENFANT,2);
		attendu = "Situation du client: client cumul\n"
			+ "\tTaxi Driver\t2.0\n"
			+ "\t11 heures 14\t3.0\n"
			+ "\tCendrillon\t1.5\n"
			+ "Total du 6.5\n"
			+ "Vous gagnez 3 points de fidelite\n";
		obtenu = unClient.situation();
		if (! attendu.equals(obtenu))
			System.out.println(attendu + obtenu);

		System.out.println("Coucou, c'est les tests qui se terminent");
	}*/
}