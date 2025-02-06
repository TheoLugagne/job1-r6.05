package prix;

public class PrixNormal extends Prix {
    @Override
    public double getPrix(int nbJours) {
        double du = 2;
        if (nbJours > 2) du += (nbJours - 2) * 1.5;
        return du;
    }

    @Override
    public int getPointsFidelites(int nbJours) {
        return 1;
    }
}
