package com.smartrec.nbeq.client;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.smartrec.nbeq.exception.ServiceClientException;
import com.smartrec.nbeq.pojo.EarthquakeCollection;

/**
 * @author Raja
 *
 * Smartrec test
 */
@TestInstance(PER_CLASS)
@DisplayName("USGOV earthquake API client test")
class USGOVEarthquakeClientTest {

    private EarthquakeCollection earthquakeCollection;

    @BeforeAll
    void setup() throws ServiceClientException {
        USGOVClient usgovEqClient = new USGOVClient();
        earthquakeCollection = usgovEqClient.getEarthquakesByMonth();
    }

    @Test
    @DisplayName("Earthquake collection type should be equal to \"FeatureCollection\"")
    void getMonthEarthquakesTypeTest() {
        Assertions.assertEquals("FeatureCollection", earthquakeCollection.getType());
    }

    @Test
    @DisplayName("Eqarthquake Return collection should not be empty")
    void getMonthEarthquakesSizeTest() {
        Assertions.assertTrue(!earthquakeCollection.getEarthquakes().isEmpty());
    }
}
