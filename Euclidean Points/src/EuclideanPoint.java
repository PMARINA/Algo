
/**
 * Euclidean Point is an abstract data type which represents n-dimensional
 * Euclidean Points
 * 
 * Assignment: ADTs refresher Project Euclidean points. Create a data type
 * EuclideanPoint.java that represents a d-dimensional point. Include a method
 * so that p.distanceTo(q) returns the Euclidean distance between points p and
 * q. Include a test class with different dimensions.
 * 
 * @author PMARINA
 * @version September 7, 2016
 *
 */
public class EuclideanPoint {
	private int dimensions; // THe number of dimensions which constitutes the
							// location of the points (2d plane or 1d line?)
	private double[] coordinates; // The coordinates in the form [x,y,z,....]

	/**
	 * A constructor for the ADT Euclidean Point
	 * 
	 * @param coordinates
	 *            the coordinates of the Euclidean Point
	 */
	public EuclideanPoint(double[] coordinates) {
		// Set the instance variables
		dimensions = coordinates.length;
		this.coordinates = coordinates;
	}

	/**
	 * Find the distance between two Euclidean Points
	 * 
	 * @param p
	 *            the other Euclidean point the user wishes to find the distance
	 *            to
	 * @return the distance from the implicit point to the specified point
	 */
	public double distanceTo(EuclideanPoint p) {
		int calcDimensions = 0; // The number of dimensions to be used by the
								// formula
		// If the points coexist in the same environment (plane/space/etc.),
		// then proceed with the formula
		if (p.dimensions == this.dimensions) {
			calcDimensions = p.dimensions;
		}
		// If there is an issue with the points not being in the same
		// environment, then let the user know that you are considering the
		// points without the excess dimensions and output the distance between
		// the two points, after placing them in the same environment.
		else {
			System.out.println(
					"Assuming that you would like to place the points in the same space, with the same number of dimensions. Disregarding extra dimensions.");
			if (p.dimensions < this.dimensions)
				calcDimensions = p.dimensions;
			else
				calcDimensions = this.dimensions;
		}
		double sumSq = 0; // The distance, squared
		for (int i = 0; i < calcDimensions; i++) {
			sumSq += Math.pow(this.coordinates[i] - p.coordinates[i], 2); // Follow
																			// Euclid's
																			// distance
																			// formula
		}
		return Math.pow(sumSq, 0.5); // Return the distance, which was squared
										// until we took square root
	}
}
