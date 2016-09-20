import java.util.Scanner;

/**
 * As the order of the curve increases, how is the area between the curve and
 * the "x-axis" affected? Modify the Koch ADT to include a method that
 * implements the area computation to assist you in answering the question.
 * Document clearly your proof.
 * 
 * Note: Instead of modifying the Koch program, I made my own as it was taking
 * too long to draw some of the larger Koch curves in order to test my output
 * 
 * output:
 * 
 * What is the input for the Koch Program?
 * -1
 * Input --- Area
 * 0    0.000000
 * 1    0.048113
 * 2    0.069496
 * 3    0.079000
 * 4    0.083223
 * 5    0.085101
 * 6    0.085935
 * 7    0.086306
 * 8    0.086471
 * 9    0.086544
 * 10   0.086576
 * 
 * @author PMARINA
 * @version 09/13/2016
 */
public class KochAreaCalc {
	/**
	 * This is the main method. It does almost nothing. Note that if you input
	 * -1 into this program, instead of proceeding with the calculation with an
	 * input of -1, it will output the Koch area for inputs 0-10 in an organized
	 * chart
	 * 
	 * @param args
	 *            - serves no actual purpose
	 */
	public static void main(String[] args) {
		// Get input
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the input for the Koch Program?");
		int input = sc.nextInt();
		// Do the calculation
		if (input != -1) {
			System.out.println("The area is " + compute(input) + " square units.");
		} else { // input ==-1, print out an organized chart
			System.out.println("Input --- Area");
			for (int i = 0; i < 11; i++) {
				System.out.printf("%-5s", i);
				System.out.printf("%6f", compute(i));
				System.out.println();
			}
		}
	}

	/**
	 * @param n
	 *            the input into the koch program
	 * @return the area between the koch curve and the x axis
	 */
	private static double compute(int n) {
		double area = 0; // The area, to be returned
		for (int i = 0; i < n; i++) {
			// Find the number of triangles of the size/type (there are an
			// (input goes here) number of different sized triangles. I know it
			// is 4^i because the program draw recursively at 4x per level of
			// recursion
			double numTriangles = Math.pow(4, i);
			// Compute the side length of the triangle of type i. This can be
			// found under the name, "step" in the original Koch program
			double sideLength = 1.0 / Math.pow(3.0, i + 1);
			// Find the apothem of the equilateral triangle, using basic trig
			double apothem = Math.sqrt(Math.pow(sideLength, 2) - Math.pow(sideLength / 2.0, 2));
			// Find the area per triangle by doing 1/2*b*h
			double areaPerTriangle = 0.5 * apothem * sideLength;
			// Add the area of all the triangles of type i to the final area
			area += numTriangles * areaPerTriangle;
		}
		return area; // Return the final area after adding the areas of all the
						// different kinds of triangles
	}
}