package statement;

import objects.Location;

import java.util.LinkedList;
import java.util.List;


public abstract class Statement {
    private String nom;
    protected final List<Location> locations = new LinkedList<Location>();

    public Statement(String nom) {
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

    public abstract String situation();



}
