package objects.prix;

public class PrixNouveau extends Prix {
    @Override
    public double getPrix(int nbJours) {
        return nbJours * 3;
    }

    @Override
    public int getPointsFidelites(int nbJours) {
        return nbJours > 1 ? 2 : 1;
    }

}
