package edu.temple.cis.paystation;

import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;


public class AlternateRateStrategy2Test {
    private AlternatingRateStrategy2 rs;

    @Before
    public void setUp(){
        rs = new AlternatingRateStrategy2();
    }

    @Test
    public void check40MinFor100(){
        rs.setDay(3);

        assertEquals(40, rs.calculateTime(100));
    }
}
