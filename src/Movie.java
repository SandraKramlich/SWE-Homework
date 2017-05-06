
public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private String title;
	public Price price;

	public Movie(String newtitle, int newpriceCode) {
		setTitle(newtitle);
		setPriceCode(newpriceCode);
	}

	public int getPriceCode() {
		return price.getPriceCode();
	}

	public void setPriceCode(int priceCode) {
		switch (priceCode) {
		case REGULAR:
			price = new RegularPrice();
			break;
		case CHILDRENS:
			price = new ChildrenPrice();
			break;
		case NEW_RELEASE:
			price = new NewReleasedPrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}

	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	int getFrequentRenterPoints(int daysRented) {
		if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
			return 2;
		else
			return 1;
	};
}
