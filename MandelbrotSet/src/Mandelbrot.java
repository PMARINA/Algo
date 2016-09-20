
import java.awt.Color;
import java.lang.Math;

/**
 * This program is a rip off of whatever princeton cs has I only made it a
 * teensy bit more efficient. Note: this takes 4 args, xc, yc, size, and maximum
 * depth (for recursion)
 * 
 * @author PMARINA
 * @version 9.20.16
 */
public class Mandelbrot {
	private static int depth = 1;

	/**
	 * @param co
	 *            complex number being plugged in represented as {re, im}
	 * @param max
	 *            the max input, whatever it used to do
	 * @return the idek
	 */
	private static int mandMod(double co[], int max) {
		double[] coCopy = { co[0], co[1] };
		for (int t = 0; t < max; t++) {
			if (abs(coCopy) > 2.0)
				return t;
			coCopy = plus(times(coCopy, coCopy), co);
		}
		return max;
	}

	/**
	 * @param comp1
	 *            - complex number 1 in form [re, im]
	 * @param comp2
	 *            - complex number 2 in form [re,im]
	 * @return the product of the two complex numbers
	 */
	public static double[] times(double[] comp1, double[] comp2) {
		double real = comp1[0] * comp2[0] - comp1[1] * comp2[1];
		double imag = comp1[0] * comp2[1] + comp1[1] * comp2[0];
		double[] ret = { real, imag };
		return ret;
	}

	/**
	 * @param c
	 *            - the complex number
	 * @return the absolute value
	 */
	public static double abs(double c[]) {
		return Math.hypot(c[0], c[1]);
	}

	/**
	 * @param a
	 *            - complex number 1 in format [re,im]
	 * @param b
	 *            - complex number 2 in format [re,im]
	 * @return the sum of the two complex numbers
	 */
	public static double[] plus(double[] a, double[] b) {

		double[] ret = new double[2];
		ret[0] = a[0] + b[0];
		ret[1] = a[1] + b[1];
		return ret;
	}

	public static void main(String[] args) {
		double xc = Double.parseDouble(args[0]);
		double yc = Double.parseDouble(args[1]);
		double size = Double.parseDouble(args[2]);
		int mD = Integer.parseInt(args[3]);

		int n = 512; // create n-by-n image
		int max = 255; // maximum number of iterations

		Picture picture = new Picture(n, n);
		drawComp(0, 0, 512, 512, 255, xc, yc, size, picture, mD);
		picture.show();
		System.out.println("Done");
	}

	public static void drawComp(int startx, int starty, int stopx, int stopy, int max, double xc, double yc,
			double size, Picture picture, int mD) {
		boolean skip = true;
		double res = 12;
		for (int i = 1; i <= res; i++) {
			for (int j = 1; j <= res; j++) {
				double x = startx + ((double) (i)) * (stopx - startx) / res; // Test
																				// points
																				// are
																				// in
																				// like
																				// a
																				// box
																				// formation
				double y = starty + ((double) (j)) * (stopy - starty) / res;
				double x0 = xc - size / 2 + size * x / 512;
				double y0 = yc - size / 2 + size * y / 512;
				double[] comp = { x0, y0 };
				if ((max - mandMod(comp, max) == 0)) {
					skip = false; // Skip is for finding whether or not the
									// program found any points
				}
				if (!skip) {
					j = (int) (res + 2);
					i = (int) (res + 2);
				}
			}
		}
		if (!skip) {
			if (depth >= mD) {// If the program has reached the maximum depth,
								// dont keep recursing, just fill it in with
								// black
				for (int i = startx; i < stopx; i++) {
					for (int j = starty; j < stopy; j++) {
						Color color = new Color(0, 0, 0);
						picture.set(i, 512 - 1 - j, color);
					}
				}
				return;
			} else {// If not at maximum depth, keep going
				depth++;
				drawComp(startx, starty, (stopx + startx) / 2, (starty + stopy) / 2, max, xc, yc, size, picture, mD);
				drawComp((stopx + startx) / 2, starty, stopx, (stopy + starty) / 2, max, xc, yc, size, picture, mD);
				drawComp(startx, (stopy + starty) / 2, (stopx + startx) / 2, stopy, max, xc, yc, size, picture, mD);
				drawComp((startx + stopx) / 2, (starty + stopy) / 2, stopx, stopy, max, xc, yc, size, picture, mD);
				depth--;
			}
		} else { // If no points found, it's white
			for (int i = startx; i < stopx; i++) {
				for (int j = starty; j < stopy; j++) {
					Color color = new Color(255, 255, 255);
					picture.set(i, 512 - 1 - j, color);
				}
			}
		}
	}
}