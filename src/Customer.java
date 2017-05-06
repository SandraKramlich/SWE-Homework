import java.util.*;

class Customer {
	private String name;
	private Vector rentals = new Vector();

	public Customer(String newname) {
		setName(newname);
	};

	public void addRental(Rental rental) {
		this.rentals.addElement(rental);
	};

	public String getName() {
		return this.name;
	};

	public void setName(String name) {
		this.name = name;
	}

	public Vector getRentals() {
		return rentals;
	}

	public void setRentals(Vector rentals) {
		this.rentals = rentals;
	}

	public String statement() {
		Enumeration enum_rentals = this.rentals.elements();
		String resultStatement = "Rental Record for " + this.getName() + "\n";
		resultStatement += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

		while (enum_rentals.hasMoreElements()) {
			Rental each = (Rental) enum_rentals.nextElement();
			// show figures for this rental
			resultStatement += "\t" + each.getMovie().getTitle() + "\t" + "\t" + each.getDaysRented() + "\t"
					+ String.valueOf(each.getMovie().price.getCharge(each.getDaysRented())) + "\n";
		}
		// add footer lines
		resultStatement += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		resultStatement += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
		return resultStatement;
	}
	
	public String htmlStatement() {
		 Enumeration rentals = this.rentals.elements();
		String resultHtmlStatement = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
		 while (rentals.hasMoreElements()) {
		 Rental each = (Rental) rentals.nextElement();
		 //show figures for each rental
		 resultHtmlStatement += each.getMovie().getTitle()+ ": " +
		 String.valueOf(each.getMovie().price.getCharge(each.getDaysRented())) + "<BR>\n";
		 }
		 //add footer lines
		 resultHtmlStatement += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) +
		"</EM><P>\n";
		 resultHtmlStatement += "On this rental you earned <EM>" +
		 String.valueOf(getTotalFrequentRenterPoints()) +
		 "</EM> frequent renter points<P>";
		 return resultHtmlStatement;
		 }

	private int getTotalFrequentRenterPoints() {
		int result = 0;
		Enumeration rentals = this.rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getMovie().price.getFrequentRenterPoints(each.getDaysRented());
		}
		return result;
	}

	private double getTotalCharge() {
		double result = 0;
		Enumeration rentals = this.rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getMovie().price.getCharge(each.getDaysRented());
		}
		return result;
	}

}