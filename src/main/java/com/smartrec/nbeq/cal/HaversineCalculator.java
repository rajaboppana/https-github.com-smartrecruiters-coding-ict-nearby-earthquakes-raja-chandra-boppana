package com.smartrec.nbeq.cal;

/**
 * @author RajaBoppana
 *
 */

//An interface can be used if there is another implementation
public class HaversineCalculator {

	/**
	 * Haversine formula to calculate distance b/w two points: a = sin²(Δφ/2) + cos
	 * φ1 ⋅ cos φ2 ⋅ sin²(Δλ/2) c = 2 ⋅ atan2(√a, √(1−a)) d = R ⋅ c φ is latitude, λ
	 * is longitude, R is earth’s radius (6,371km).
	 * 
	 */

	public long calculateDistance(double latitude, double longitude, double lat, double lon) {
		double lat1InRadians = Math.toRadians(latitude);
		double lat2InRadians = Math.toRadians(lat);
		double latDeltaRadians = Math.toRadians(lat - latitude);
		double lonDeltaRadians = Math.toRadians(lon - longitude);
		double a = Math.sin(latDeltaRadians / 2) * Math.sin(latDeltaRadians / 2) + Math.cos(lat1InRadians)
				* Math.cos(lat2InRadians) * Math.sin(lonDeltaRadians / 2) * Math.sin(lonDeltaRadians / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		// Multiply with radius of Earth
		return Math.round(6371 * c);
	}

}
