package statement;

public class TextStatement extends Statement {
    public TextStatement(String nom) {
        super(nom);
    }

    @Override
    public String situation() {
        return "Situation du client: " + getNom() + "\n" + getSituations() +
                "Total du " + String.valueOf(getMontantTotal()) + "\n" +
                "Vous gagnez " + String.valueOf(getPointsFidelites()) + " points de fidelite\n";

    }


}
