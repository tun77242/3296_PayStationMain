package edu.temple.cis.paystation;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
public class ProgressiveRateStrategyTest {
    private RateStrategy rs;
    @Before
    public void setUp() {
        rs = new ProgressiveRateStrategy();
    }
    // First Hour
    @Test
    public void Check40MinsFor100() {
        assertEquals(40, rs.calculateTime(100));
    }
    // Second Hour
    @Test
    public void Check105MinsFor300() {
        assertEquals(105, rs.calculateTime(300));
    }
    //Three hours
    @Test
    public void Check130MinsFor400() {
        assertEquals(130, rs.calculateTime(400));
    }
    //Test Four hours
    @Test
    public void Check210MinsFor800() {
        assertEquals(210, rs.calculateTime(800));
    }
}
