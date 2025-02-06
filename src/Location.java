public class Location {
	private Film unFilm;
	private int nbJours;
	
	public Location(Film unFilm, int nbJours) {
		this.unFilm = unFilm;
		this.nbJours = nbJours;
	}

	public int getNbJours() {
		return this.nbJours;
	}

	public Film getFilm() {
		return this.unFilm;
	}

	public double getLocationPrice() {
		//determine le montant de chaque location
		double du = 0;
		switch (this.unFilm.getCodePrix()) {
			case Film.NORMAL:
				du += 2;
				if (this.nbJours > 2)
					du += (this.nbJours - 2) * 1.5;
				break;
			case Film.NOUVEAUTE:
				du += this.nbJours * 3;
				break;
			case Film.ENFANT:
				du += 1.5;
				if (this.nbJours > 3)
					du += (this.nbJours - 3) * 1.5;
				break;
		}
		return du;
	}

	public int getPointsFidelites() {
		// ajout des points de fidelite
		int pointsFidelites = 1;
		// ajout d'un bonus pour les nouveautes louees depuis au moins deux jours
		if ((this.unFilm.getCodePrix() == Film.NOUVEAUTE) && this.nbJours > 1)
			pointsFidelites++;
		return pointsFidelites;
	}

	@Override
	public String toString() {
		return "\t" + this.getFilm().getTitre() + "\t" + this.getLocationPrice() + "\n";
	}
}