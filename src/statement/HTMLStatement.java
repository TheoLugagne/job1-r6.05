package statement;

import objects.Client;

public class HTMLStatement extends Statement {


    @Override
    public String situation(Client client) {
        return "<p>Situation du client: " + client.getNom() + "</p>\n" +
               "<p>" + client.getSituations() + "</p>\n" +
               "<p>Total du " + client.getMontantTotal() + "</p>\n" +
               "<p>Vous gagnez " + client.getPointsFidelites() + " points de fidélité</p>\n";
    }


}
