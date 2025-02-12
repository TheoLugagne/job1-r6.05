package statement;

import objects.Client;

public class TextStatement extends Statement {

    @Override
    public String situation(Client client) {
        return "Situation du client: " + client.getNom() + "\n" + client.getSituations() +
                "Total du " + client.getMontantTotal() + "\n" +
                "Vous gagnez " + client.getPointsFidelites() + " points de fidelite\n";

    }


}
