package objects.prix;

public class PrixCinephile extends Prix{
    @Override
    public double getPrix(int nbJours) {
        return nbJours <= 1 ? 2 : 2 + 4 *(nbJours-1);

    }

    @Override
    public int getPointsFidelites(int nbJours) {
        return nbJours <= 1 ? 3  : 0;
    }
}
