package objects;

import java.util.LinkedList;
import java.util.List;

public class Client {
	private final String nom;
	private final List<Location> locations = new LinkedList<>();
	
	public Client(String nom) {
		this.nom = nom;
	}
	
	public void addLocation(Location location) {
		this.locations.add(location);
	}
	
	public String getNom() {
		return this.nom;
	}

	public double getMontantTotal() {
		double totalDu = 0;
        for (Location each : locations) {
            totalDu += each.getFilm().getPrix(each.getNbJours());
        }
		return totalDu;
	}

	public int getPointsFidelites() {
		int pointsFidelites = 0;
		for (Location each : locations) {
			pointsFidelites += each.getFilm().getPointsFidelites(each.getNbJours());
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
