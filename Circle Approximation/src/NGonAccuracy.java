import java.util.Scanner;

/**
 * Regular n-gons. Ngon.java takes a command-line argument n and draws a regular
 * n-gon using turtle graphics. By taking n to a sufficiently large value, we
 * obtain a good approximation to a circle. Show your images as n increases.
 * Implement an algorithm to find the smallest value for n to get the best
 * approximation to a circle. Document clearly your proof.
 * 
 * This algorithm takes the number of sides a shape has, assumes that the radius
 * of the shape (from the centre to the vertex distance) is 0.5 (as assumed by
 * StdDraw), and computes the percent error by finding the areas of the circle
 * and the regular ngon.
 * 
 * @author PMARINA
 * @version 9/12/2016
 */
public class NGonAccuracy {
	/**
	 * This algorithm takes the number of sides a shape has, assumes that the
	 * radius of the shape (from the centre to the vertex distance) is 0.5 (as
	 * assumed by StdDraw), and computes the percent error by finding the areas
	 * of the circle and the regular ngon.
	 * 
	 * @param args
	 *            - serves no purpose
	 */
	public static void main(String[] args) {
		// Get user input
		System.out.println("What is the number of sides being used?");
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();

		// Compute areas of the regular ngon and the circle
		double acceptedVal = circleCalculator();
		double currentVal = regArea(c);
		// Compute the percent error given these two values
		double percentError = 100 * (Math.abs(acceptedVal - currentVal) / acceptedVal);
		System.out.println("Your error is: " + percentError + "%");
	}

	/**
	 * Finds the area of a circle of radius 0.5 units. Uses pi * r^2.
	 * 
	 * @return the area of a circle with the radius 0.5 units
	 */
	public static double circleCalculator() {
		return Math.PI * 0.5 * 0.5;
	}

	/**
	 * compute the area of a regular polygon through the following formula
	 * (numSides * sideLength^2)/(4*tan(180/numSides)), where the tan is in
	 * degrees
	 * 
	 * @param c
	 *            the number of sides
	 * @return the area, assuming that the shape's diameter is 1
	 */
	public static double regArea(int c) {
		double angle = 360.0 / c;
		double step = Math.sin(Math.toRadians(angle / 2.0));
		double numerator = c * Math.pow(step, 2);
		double denominator = 4 * Math.tan(Math.toRadians(180.0 / c));
		return numerator / denominator;
	}
}
