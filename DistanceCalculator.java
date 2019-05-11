package com.example.gps_test;

import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.abs;
import static java.lang.Math.atan2;
import static java.lang.Math.sqrt;

public class DistanceCalculator { // return distance (meter)
    static double DEGtoRAD = Math.PI / 180;

    public double GreatMeters(double lat1, double lon1, double lat2, double lon2) {
        double phi1 = lat1 * DEGtoRAD;
        double phi2 = lat2 * DEGtoRAD;
        double lambda1 = lon1 * DEGtoRAD;
        double lambda2 = lon2 * DEGtoRAD;

        double a = sin(abs(phi1 - phi2)/2) * sin(abs(phi1 - phi2)/2) + cos(phi1) * cos(phi2) * sin(abs(lambda1 - lambda2)/2) * sin(abs(lambda1 - lambda2)/2);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));
        double d = 6371.01 * 1000 * c;

        return d;
    }

    public double DistanceUpdates(double old, double newd) {
        double smoothV = 1.0;
        double updateV = old + (newd - old) / smoothV;

        return updateV;
    }
}