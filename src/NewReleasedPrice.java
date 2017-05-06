
public class NewReleasedPrice extends Price {
	@Override
	double getCharge(int daysRented) {
		return daysRented * 3;
	}

	@Override
	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}
	
	@Override
	int getFrequentRenterPoints(int daysRented) {
		return (daysRented > 1) ? 2 : 1;
	}
}
