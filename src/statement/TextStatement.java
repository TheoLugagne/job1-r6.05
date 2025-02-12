package statement;

import objects.Client;
import objects.Location;

import java.util.List;

public class TextStatement extends Statement {

    @Override
    public String situation(Client client) {
        return "Situation du client: " + client.getNom() + "\n" + getSituationLocation(client.getLocations()) +
                "Total du " + client.getMontantTotal() + "\n" +
                "Vous gagnez " + client.getPointsFidelites() + " points de fidelite\n";

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
