class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie newmovie, int newdaysRented) {
		this.movie = newmovie;
		this.daysRented = newdaysRented;
	}

	public int getDaysRented() {
		return this.daysRented;
	}

	public Movie getMovie() {
		return this.movie;
	}

	int getFrequentRenterPoints() {
		if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) return 2;
		else return 1;
	}
}