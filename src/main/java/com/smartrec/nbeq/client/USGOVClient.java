package com.smartrec.nbeq.client;

import com.smartrec.nbeq.exception.ServiceClientException;
import com.smartrec.nbeq.pojo.EarthquakeCollection;
import com.smartrec.nbeq.utils.PropertiesHandler;

/**
 * @author RajaBoppana
 * Child class to implement to invoke REST API call
 * https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson
 *
 */
public class USGOVClient extends ServiceClient implements EarthquakeData {

    private static final String EARTHQUAKES_URI = "usgov.earthquakes.uri";
    private static final String EQ_MONTH_LIMIT = "usgov.earthquakes.nearby.limit";
    private static final String PROPERTIES_FILE = "usgovearthquakes.properties";

    @Override
    public EarthquakeCollection getEarthquakesByMonth() throws ServiceClientException {
        PropertiesHandler propertiesHandler = new PropertiesHandler(PROPERTIES_FILE);
        String monthEarthquakesUri = propertiesHandler.getProperty(EARTHQUAKES_URI);
        int count = Integer.parseInt(propertiesHandler.getProperty(EQ_MONTH_LIMIT));
        return get(monthEarthquakesUri, EarthquakeCollection.class);
    }
}
