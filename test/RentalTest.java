import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RentalTest {

    private Rental r1;
    private Rental r2;
    private Movie m1;
    private Movie m2;
    private double EXPECTED1 = 15.0;
    private double EXPECTED2 = 12.0;

    @Before
    public void setup() {
        m1 = new Movie("movie1", 1);
        m2 = new Movie("movie2", 2);
        r1 = new Rental(m1, 5);
        r2 = new Rental(m2, 10);
    }

    @Test
    public void testSettingDaysRented() throws Exception {
        assertEquals(5, r1.getDaysRented());
        assertEquals(10, r2.getDaysRented());
    }

    @Test
    public void testSettingMovie() throws Exception {
        assertEquals(m1, r1.getMovie());
        assertEquals(m2, r2.getMovie());
    }

	@Test
    public void testAmountCalculation() throws Exception{
    	assertEquals(EXPECTED1, r1.getCharge(),0);
    	assertEquals(EXPECTED2, r2.getCharge(),0);
    }
	
	@Test
    public void testFrequentRenterPoints() throws Exception{
    	assertEquals(2, r1.getFrequentRenterPoints(),0);
    	assertEquals(1, r2.getFrequentRenterPoints(),0);
    }
}