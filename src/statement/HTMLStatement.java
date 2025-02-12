package statement;

import objects.Client;
import objects.Location;

import java.util.List;

public class HTMLStatement extends Statement {

    @Override
    public String getSituationLocation(Location location) {
        return "<p>"+location.toString() + "</p>\n";
    }

    @Override
    public String getHeader(Client client) {
        return "<p>Situation du client: " + client.getNom() + "</p>\n";
    }

    @Override
    public String getFooter(Client client) {
        return "<p>Total du " + client.getMontantTotal() + "</p>\n" +
                "<p>Vous gagnez " + client.getPointsFidelites() + " points de fidélité</p>\n";
    }


}
