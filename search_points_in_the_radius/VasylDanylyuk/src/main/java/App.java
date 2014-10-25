//FIXME commit packages into GitHub. The whole structure should be committed. Not only classes, but packages too. 

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by Vasyl Danylyuk on 15.10.2014.
 */
// FIXME Give more understadable name for the main class.
public class App {
	public static void main(String[] args) {
		// FIXME Move all 'magic' numbers into constants
		Collection<IPoint> points = new HashSet<IPoint>(200, 1);

		Random random = new Random();
		for (int i = 0; i < 200; i++) {
			// FIXME Move all 'magic' numbers into constants
			points.add(new PointByGeoCoordinates(random.nextDouble() / 10 + 48.86, random.nextDouble() / 10 + 24.63)); // 48.9133962,24.9172989
		}

		IPointsFinder pointsOnMap = new PointsOnMap(points);

		IPoint myPosition = new PointByGeoCoordinates(48.9120, 24.68753527258d);

		int radius = 800;

		// FIXME vulnerable place. NullPointerException could be thrown. Add
		// 'null' check and only then retrieve values from collection.
		for (IPoint currentPoint : pointsOnMap.getPointsNearMe(myPosition, radius)) {
			System.out.println(currentPoint);
		}
	}
}
