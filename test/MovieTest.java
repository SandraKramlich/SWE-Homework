import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MovieTest {

    private Movie m1;

    @Before
    public void setup() {
        m1 = new Movie("movie1", 1);
    }

    @Test
    public void testSettingTitle() throws Exception {
        assertEquals("movie1", m1.getTitle());
    }

    @Test
    public void testSettingPrice() throws Exception {
        assertEquals(1, m1.getPriceCode());
        m1.setPriceCode(2);
        assertEquals(2, m1.getPriceCode());
    }

}