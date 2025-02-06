package prix;

public class PrixEnfant extends Prix{
    @Override
    public double getPrix(int nbJours) {
        double du = 1.5;
        if (nbJours > 3) du += (nbJours - 3) * 1.5;
        return du;
    }

    @Override
    public int getPointsFidelites(int nbJours) {
        return 1;
    }
}
