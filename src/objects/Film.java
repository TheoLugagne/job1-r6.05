package objects;

import objects.prix.Prix;
import objects.prix.PrixEnfant;
import objects.prix.PrixNormal;
import objects.prix.PrixNouveau;

public class Film {
	
	public static final int ENFANT = 2;
	public static final int NOUVEAUTE = 1;
	public static final int NORMAL = 0;
	
	private String titre;
	private Prix prix;
	private int codePrix;
	
	public Film(String titre, int codePrix) {
		this.titre = titre;
		this.codePrix = codePrix;
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

	public int getCodePrix() {
		return this.codePrix;
	}
	
}