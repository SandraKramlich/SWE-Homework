
public class ChildrenPrice extends Price {
	@Override
	double getCharge(int daysRented) {
		double result = 1.5;
		if (daysRented > 3) {
			result += (daysRented - 3) * 1.5;
		}
		return result;
	}

	@Override
	int getPriceCode() {
		return Movie.CHILDRENS;
	}

	@Override
	int getFrequentRenterPoints(int daysRented) {
		return 1;
	}

}
