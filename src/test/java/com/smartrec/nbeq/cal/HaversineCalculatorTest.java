package com.smartrec.nbeq.cal;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

/**
 * @author Raja
 *
 * Smartrec test
 */
@TestInstance(PER_CLASS)
@DisplayName("Haversine distance calculator check")
class HaversineCalculatorTest {

    private HaversineCalculator calc;

    @BeforeAll
    void setup() {
        calc = new HaversineCalculator();
    }

    @Test
    @Disabled
    @DisplayName("Calculated distance should be equal to expected")
    void calculateTest() {
        assertEquals(8661.57204095562, calc.calculateDistance(44.678910, -21.987654, 0, 0));
    }
}
