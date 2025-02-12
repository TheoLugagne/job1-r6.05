package statement;

import objects.Client;
import objects.Location;


public class TextStatement extends Statement {

    @Override
    public String getSituationLocation(Location location) {
        return location.toString() + "\n";
    }

    @Override
    public String getHeader(Client client) {
        return "Situation du client: " + client.getNom() + "\n";
    }

    @Override
    public String getFooter(Client client) {
        return "Total du " + client.getMontantTotal() + "\n" +
                "Vous gagnez " + client.getPointsFidelites() + " points de fidelite\n";
    }


}
