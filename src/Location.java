public class Location {
	private Film unFilm;
	private int nbJoursLocation;
	
	public Location(Film unFilm, int nbJoursLocation) {
		this.unFilm = unFilm;
		this.nbJoursLocation = nbJoursLocation;
	}

	public int getNbJoursLocation() {
		return this.nbJoursLocation;
	}

	public Film getFilm() {
		return this.unFilm;
	}
	
}