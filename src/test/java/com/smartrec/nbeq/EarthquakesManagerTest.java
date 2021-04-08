package com.smartrec.nbeq;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.smartrec.nbeq.exception.DataException;

/**
 * @author Raja
 *
 * Smartrec test
 */

@TestInstance(PER_CLASS)
@DisplayName("Earthquakes manager check")
class EarthquakesManagerTest {

    private EQManager eqManager;

    @BeforeAll
    void setup() {
    	eqManager = new EQManager();
    }

    @Test
    @DisplayName("Earthquakes map cannot not be empty")
    void getEarthquakeDetailsTest() throws DataException {
        assertTrue(!eqManager.getEarthquakeDetails(45.980565, -77.906543).isEmpty());
    }

    @Test
    @DisplayName("Nearby earthquakes map cannot not be empty")
    void getNearbyEarthquakeDetailsTest() throws DataException {
        assertTrue(!eqManager.getNearbyEarthquakeDetails(40.987343, -73.676767).isEmpty());
    }

}
