
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Client {
	private final String nom;
	private final List<Location> locations = new LinkedList<Location>();
	
	public Client(String nom) {
		this.nom = nom;
	}
	
	public void addLocation(Location location) {
		this.locations.add(location);
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String situation() {
		double totalMontantLocation = 0;
		int pointsFidelites = 0;
		Iterator<Location> locationIterator = locations.iterator();
		String result = "Situation du client: " + getNom() + "\n";
		
		while (locationIterator.hasNext()) {
			Location location = (Location) locationIterator.next();
			double montantLocation = getMontantLocation(location);
			// ajout des points de fidelite
			pointsFidelites++;
			// ajout d'un bonus pour les nouveautes louees depuis au moins deux jours
			if ((location.getFilm().getCodePrix() == Film.NOUVEAUTE) && location.getNbJoursLocation() > 1)
				pointsFidelites++;
			
			// mise en forme location
			result += "\t" + location.getFilm().getTitre() + "\t" + montantLocation + "\n";
			totalMontantLocation += montantLocation;
		}
		
		// ajout recapitulatif client
		result += "Total du " + totalMontantLocation + "\n";
		result += "Vous gagnez " + pointsFidelites + " points de fidelite\n";
		
		return result;
	}

	private static double getMontantLocation(Location location) {
		double montantLocation = 0;
		//determine le montant de chaque location
		switch (location.getFilm().getCodePrix()) {
		case Film.NORMAL:
			montantLocation += 2;
			if (location.getNbJoursLocation() > 2)
				montantLocation += (location.getNbJoursLocation() - 2) * 1.5;
			break;
		case Film.NOUVEAUTE:
			montantLocation += location.getNbJoursLocation() * 3;
			break;
		case Film.ENFANT:
			montantLocation += 1.5;
			if (location.getNbJoursLocation() > 3)
				montantLocation += (location.getNbJoursLocation() - 3) * 1.5;
			break;
		}
		return montantLocation;
	}

}
