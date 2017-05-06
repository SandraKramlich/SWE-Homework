import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	private static final String EXPECTED = "Rental Record for joe\n" + "\tTitle\t\tDays\tAmount\n"
			+ "\tmovie1\t\t10\t30.0\n" + "\tmovie2\t\t5\t4.5\n" + "Amount owed is 34.5\n"
			+ "You earned 3 frequent renter points";

	private static final String HTMLEXPECTED = "<H1>Rentals for <EM>joe</EM></H1><P>\n"
			+ "movie1: 30.0<BR>\nmovie2: 4.5<BR>\n<P>You owe <EM>34.5</EM><P>\nOn this rental you earned <EM>3</EM> frequent renter points<P>";

	private Customer customer;
	private Movie m1;
	private Movie m2;

	@Before
	public void setup() {
		customer = new Customer("joe");
		m1 = new Movie("movie1", 1);
		m2 = new Movie("movie2", 2);
	}

	@Test
	public void testStatement() throws Exception {
		Rental r1 = new Rental(m1, 10);
		customer.addRental(r1);
		Rental r2 = new Rental(m2, 5);
		customer.addRental(r2);
		assertEquals(EXPECTED, customer.statement());
	}

	@Test
	public void testHtmlStatement() throws Exception {
		Rental r1 = new Rental(m1, 10);
		customer.addRental(r1);
		Rental r2 = new Rental(m2, 5);
		customer.addRental(r2);
		assertEquals(HTMLEXPECTED, customer.htmlStatement());
	}

	@Test
	public void testSettingName() throws Exception {
		assertEquals("joe", customer.getName());
	}

}