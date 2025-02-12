package statement;

public class HTMLStatement extends Statement {

    public HTMLStatement(String nom) {
        super(nom);
    }

    @Override
    public String situation() {
return "<p>Situation du client: " + getNom() + "</p>\n" +
       "<p>" + getSituations() + "</p>\n" +
       "<p>Total du " + String.valueOf(getMontantTotal()) + "</p>\n" +
       "<p>Vous gagnez " + String.valueOf(getPointsFidelites()) + " points de fidélité</p>\n";
    }


}
