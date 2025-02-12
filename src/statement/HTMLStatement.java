package statement;

import objects.Client;
import objects.Location;

import java.util.List;

public class HTMLStatement extends Statement {


    @Override
    public String situation(Client client) {
        return "<p>Situation du client: " + client.getNom() + "</p>\n" +
               "<p>" + getSituationLocation(client.getLocations()) + "</p>\n" +
               "<p>Total du " + client.getMontantTotal() + "</p>\n" +
               "<p>Vous gagnez " + client.getPointsFidelites() + " points de fidélité</p>\n";
    }

    @Override
    public String getSituationLocation(List<Location> locations) {
        StringBuilder situationBuilder = new StringBuilder();
        for (Location each : locations) {
            situationBuilder.append(each.toString());
        }
        return situationBuilder.toString();
    }


}
