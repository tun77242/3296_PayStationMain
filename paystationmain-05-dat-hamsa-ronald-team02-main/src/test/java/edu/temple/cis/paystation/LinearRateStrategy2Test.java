package edu.temple.cis.paystation;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LinearRateStrategy2Test {
    private RateStrategy rs;
    @Before
    public void setUp() {
        rs = new LinearStrategyRate2();
    }
    @Test
    public void Check100MinsFor500() {
        assertEquals(100, rs.calculateTime(500));
    }
}
