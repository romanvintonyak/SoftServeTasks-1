
import java.util.Collection;

/**
 * Created by Vasyl Danylyuk on 18.10.2014.
 */
public interface IPointsFinder {
    Collection<IPoint> getPointsNearMe(IPoint targetPoint, int radius);
}
