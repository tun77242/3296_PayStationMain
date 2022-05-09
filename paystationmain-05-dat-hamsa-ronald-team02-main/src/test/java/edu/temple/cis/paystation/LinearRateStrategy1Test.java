package edu.temple.cis.paystation;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
public class LinearRateStrategy1Test {
  private RateStrategy rs;
    @Before
    public void setUp() {
        rs = new LinearRateStrategy1();
    }
    @Test
    public void Check120MinsFor300() {
        assertEquals(120, rs.calculateTime(300));
    }
}
