package objects;

import objects.prix.*;

public class Film {

	public static final int CINEPHILE = 4;
	public static final int COFFRET_SERIE_TV = 3;
	public static final int ENFANT = 2;
	public static final int NOUVEAUTE = 1;
	public static final int NORMAL = 0;
	
	private final String titre;
	private Prix prix;

    public Film(String titre, int codePrix) {
		this.titre = titre;
        this.setCodePrix(codePrix);
	}

	public String getTitre() {
		return this.titre;
	}

	public void setCodePrix(int codePrix) {
		switch (codePrix) {
			case ENFANT:
				this.prix = new PrixEnfant();
				break;
			case NOUVEAUTE:
				this.prix = new PrixNouveau();
				break;
			case NORMAL:
				this.prix = new PrixNormal();
				break;
			case COFFRET_SERIE_TV:
				this.prix = new PrixCoffretSerieTV();
				break;
			case CINEPHILE:
				this.prix = new PrixCinephile();
				break;
			default:
				throw new IllegalArgumentException("Code de prix invalide");
		}
	}

	public double getPrix(int nbJours) {
		return this.prix.getPrix(nbJours);
	}

	public int getPointsFidelites(int nbJours) {
		return this.prix.getPointsFidelites(nbJours);
	}
	
}