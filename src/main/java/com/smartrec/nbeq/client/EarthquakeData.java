package com.smartrec.nbeq.client;

import com.smartrec.nbeq.exception.DataException;
import com.smartrec.nbeq.pojo.EarthquakeCollection;

/**
 * @author RajaBoppana
 *
 */
public interface EarthquakeData {

    EarthquakeCollection getEarthquakesByMonth() throws DataException;

    default void shutdown() {
    	
    }
}
