package edu.temple.cis.paystation;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class AlternateRateStrategyTest {
    private AlternatingRateStrategy rs;

    @Before
    public void setUp(){
        rs = new AlternatingRateStrategy();
    }

    @Test
    public void weekDayTest(){
        rs.setDay(2);

        assertEquals(114, rs.calculateTime(330));
        assertEquals(44, rs.calculateTime(110));
        assertEquals(122, rs.calculateTime(360));
    }

    @Test
    public void weekEndTest(){
        rs.setDay(1);

        assertEquals(20, rs.calculateTime(50));
    }
}
