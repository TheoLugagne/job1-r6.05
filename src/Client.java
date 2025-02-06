
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Client {
	private String nom;
	private List<Location> locations = new LinkedList<Location>();
	
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
        return "Situation du client: " + getNom() + "\n" + getSituations() +
                "Total du " + String.valueOf(getMontantTotal()) + "\n" +
                "Vous gagnez " + String.valueOf(getPointsFidelites()) + " points de fidelite\n";
	}

	public double getMontantTotal() {
		double totalDu = 0;
        for (Location each : locations) {
            totalDu += each.getLocationPrice();
        }
		return totalDu;
	}

	public int getPointsFidelites() {
		int pointsFidelites = 0;
		for (Location each : locations) {
			pointsFidelites += each.getPointsFidelites();
		}
		return pointsFidelites;
	}

	public String getSituations() {
        StringBuilder situationBuilder = new StringBuilder();
        for (Location each : locations) {
			situationBuilder.append(each.toString());
		}
        return situationBuilder.toString();
	}
}
