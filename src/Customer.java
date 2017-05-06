import java.util.*;

class Customer {
	private String name;
	private Vector rentals = new Vector();

	public Customer(String newname) {
		this.name = newname;
	};

	public void addRental(Rental rental) {
		this.rentals.addElement(rental);
	};

	public String getName() {
		return this.name;
	};

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration enum_rentals = this.rentals.elements();
		String resultStatement = "Rental Record for " + this.getName() + "\n";
		resultStatement += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

		while (enum_rentals.hasMoreElements()) {
			Rental each = (Rental) enum_rentals.nextElement();
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPoints++;
			// show figures for this rental
			resultStatement += "\t" + each.getMovie().getTitle() + "\t" + "\t" + each.getDaysRented() + "\t"
					+ String.valueOf(each.getCharge()) + "\n";
			totalAmount += each.getCharge();
		}
		// add footer lines
		resultStatement += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		resultStatement += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return resultStatement;
	}

}