package com.smartrec.nbeq;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.smartrec.nbeq.cal.HaversineCalculator;
import com.smartrec.nbeq.client.EarthquakeData;
import com.smartrec.nbeq.client.USGOVClient;
import com.smartrec.nbeq.exception.DataException;
import com.smartrec.nbeq.pojo.Earthquake;
import com.smartrec.nbeq.utils.PropertiesHandler;

/**
 * @author RajaBoppana
 *
 */

public class EQManager {

	private static final Logger LOGGER = LogManager.getLogger();

	private static final String EQ_MONTH_LIMIT = "usgov.earthquakes.nearby.limit";
	 private static final String PROPERTIES_FILE = "usgovearthquakes.properties";

	private EarthquakeData dataSrc;

	// Get Earthquake details using datasource and create a map
	public Map<Long, Earthquake> getEarthquakeDetails(double latitude, double longitude) throws DataException {
		dataSrc = new USGOVClient();
		List<Earthquake> eqList = dataSrc.getEarthquakesByMonth().getEarthquakes();
		Map<Long, Earthquake> eqMapByDistance = new TreeMap<>();
		HaversineCalculator haversineCalculator = new HaversineCalculator();

		eqList.forEach(eq -> {
			double eqLatitude = eq.getGeometry().getCoordinates().get(1);
			double eqLongitude = eq.getGeometry().getCoordinates().get(0);
			long distance = haversineCalculator.calculateDistance(latitude, longitude, eqLatitude, eqLongitude);
			eqMapByDistance.put(distance, eq);
		});

		return eqMapByDistance;
	}

	// Get Nearby Earthquake details using the map
	public Map<Long, Earthquake> getNearbyEarthquakeDetails(double latitude, double longitude) throws DataException {
		PropertiesHandler prop_handler = new PropertiesHandler(PROPERTIES_FILE);
		int count = Integer.parseInt(prop_handler.getProperty(EQ_MONTH_LIMIT));
		Map<Long, Earthquake> allEarthquakes = getEarthquakeDetails(latitude, longitude);
		return allEarthquakes.entrySet().stream().limit(count).collect(TreeMap::new,
				(limited, all) -> limited.put(all.getKey(), all.getValue()), Map::putAll);
	}

	// Logging output the details in console.
	public String getPrintableNearbyEarthquakes(double latitude, double longitude) throws DataException {

		Map<Long, Earthquake> earthquakes = getNearbyEarthquakeDetails(latitude, longitude);
		StringBuilder stringBuilder = new StringBuilder();

		earthquakes.forEach((distance, earthquake) -> {
			if (stringBuilder.toString().isEmpty()) {
				stringBuilder.append(earthquake.getProperties().getTitle()).append(" || ").append(distance);
			} else {
				stringBuilder.append("\n").append(earthquake.getProperties().getTitle()).append(" || ")
						.append(distance);
			}
		});
		return stringBuilder.toString();
	}

	public void shutdown() {
		dataSrc.shutdown();
	}
}