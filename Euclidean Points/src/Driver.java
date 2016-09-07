
/**
 * @author PMARINA
 * @version September 7, 2016
 * 
 * 
 *          Output:
 * 
 *          Assuming that you would like to place the points in the same space,
 *          with the same number of dimensions. Disregarding extra dimensions.
 * 
 *          1.0
 * 
 *          7.0710678118654755
 *
 * 
 */
public class Driver {
	/**
	 * Should print an error message reporting coordinates in different spaces,
	 * then it should move points to the same space. Finally, it should print
	 * the distnace from the two cospatial points. Then, it should print out the
	 * distance between two points in the same plane.
	 * 
	 * Expected output:
	 * 		error message 
	 * 		1.0 
	 * 		5rt2, rounded
	 * 
	 * @param args
	 *            Has no function
	 */
	public static void main(String[] args) {
		// create the arrays representing the coordinates
		double[] p1Coords = { 0, 4, 5 }; // 3d
		double[] p2Coords = { 0, 5 };// 2d
		double[] p3Coords = { 5, 0 };// 2d

		// Create the points
		EuclideanPoint p1 = new EuclideanPoint(p1Coords);
		EuclideanPoint p2 = new EuclideanPoint(p2Coords);
		EuclideanPoint p3 = new EuclideanPoint(p3Coords);

		// output and computation
		System.out.println(p1.distanceTo(p2));
		System.out.println(p2.distanceTo(p3));
	}
}
