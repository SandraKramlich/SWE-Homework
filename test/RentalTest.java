import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RentalTest {

    private Rental r1;
    private Movie m1;
    private double EXPECTED = 15.0;

    @Before
    public void setup() {
        m1 = new Movie("movie1", 1);
        r1 = new Rental(m1, 5);
    }

    @Test
    public void testSettingDaysRented() throws Exception {
        assertEquals(5, r1.getDaysRented());
    }

    @Test
    public void testSettingMovie() throws Exception {
        assertEquals(m1, r1.getMovie());
    }

	@Test
    public void testAmountCalculation() throws Exception{
    	assertEquals(EXPECTED, r1.getCharge(),0);
    }
}