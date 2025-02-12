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
        for (Location location : locations) {
            totalDu += location.getFilm().getPrix(location.getNbJours());
        }
		return totalDu;
	}

	public int getPointsFidelites() {
		int pointsFidelites = 0;
		for (Location location : locations) {
			pointsFidelites += location.getFilm().getPointsFidelites(location.getNbJours());
		}
		return pointsFidelites;
	}

	public List<Location> getLocations() {
		return locations;
	}
}
