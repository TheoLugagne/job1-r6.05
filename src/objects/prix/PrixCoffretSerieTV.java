package objects.prix;

public class PrixCoffretSerieTV extends Prix{
    @Override
    public double getPrix(int nbJours) {
        return nbJours * 0.5;
    }

    @Override
    public int getPointsFidelites(int nbJours) {
        return 0;
    }
}
