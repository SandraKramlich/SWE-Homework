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
		int frequentRenterPoints = 0;
		Enumeration enum_rentals = this.rentals.elements();
		String resultStatement = "Rental Record for " + this.getName() + "\n";
		resultStatement += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

		while (enum_rentals.hasMoreElements()) {
			Rental each = (Rental) enum_rentals.nextElement();
			frequentRenterPoints += each.getFrequentRenterPoints();
			// show figures for this rental
			resultStatement += "\t" + each.getMovie().getTitle() + "\t" + "\t" + each.getDaysRented() + "\t"
					+ String.valueOf(each.getCharge()) + "\n";
		}
		// add footer lines
		resultStatement += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		resultStatement += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return resultStatement;
	}

	private double getTotalCharge() {
		double result = 0;
		Enumeration rentals = this.rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}

}