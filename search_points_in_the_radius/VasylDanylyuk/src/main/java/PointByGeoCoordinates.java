/**
 * Created by Vasyl Danylyuk on 15.10.2014.
 */
public class PointByGeoCoordinates implements IPoint {
    private double latitude;
    private double longitude;

    @Override
    public String toString() {
        return "{ \"lat\" :" +
                  latitude + ", \"lng\" :  " +
                  longitude +
                '}';
    }

    public PointByGeoCoordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitudeOnRad() {
    	//FIXME Move all 'magic' numbers into constants
        return latitude/180*Math.PI;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitudeOnRad() {
        return longitude/180*Math.PI;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
