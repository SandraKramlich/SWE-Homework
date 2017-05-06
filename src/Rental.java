class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie newmovie, int newdaysRented) {
		setMovie(newmovie);
		setDaysRented(newdaysRented);
	}

	public int getDaysRented() {
		return this.daysRented;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}
}