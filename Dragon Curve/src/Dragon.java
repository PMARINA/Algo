/******************************************************************************
 *  Compilation:  javac Dragon.java
 *  Execution:    java Dragon n
 * 
 *  Draws dragon curve of order n.
 *
 *  % java Dragon 7
 *
 *  Limitations
 *  -------------
 *    -  N must be between 1 and 15
 *
 ******************************************************************************/


public class Dragon {
    private Turtle turtle;

    public Dragon(int n) {
       /***********************************************************************
        *  The following constants are used to figure out where to start         
        *  drawing the dragon curve.  left[i] = maximum number of steps taken
        *  to the left in dragon(i).  right[i], up[i], down[i] are similar.
        ***********************************************************************/
        int[] left  = { 0, 0, 0, 2, 4, 5, 5,  5,  5,  5, 10, 42, 74, 81,  85,  85 };
        int[] right = { 1, 1, 1, 1, 1, 1, 2, 10, 18, 21, 21, 21, 21, 21,  57, 170 };
        int[] up    = { 0, 1, 2, 2, 2, 2, 2,  2,  5, 21, 37, 42, 42, 42,  42,  42 };
        int[] down  = { 0, 0, 0, 0, 1, 5, 9, 10, 10, 10, 10, 10, 23, 85, 149, 165 };


        double size = Math.max(left[n] + right[n], up[n] + down[n]);
        double x = (right[n] - left[n]) / 2.0;
        double y = (up[n]    - down[n]) / 2.0;

        turtle = new Turtle(0.0, 0.0, 0.0);
        turtle.setXscale(x - size/2, x + size/2);
        turtle.setYscale(y - size/2, y + size/2);
        dragon(n);
    }


    // dragon curve of order n
    public void dragon(int n) {
        if (n == 0) {
            turtle.goForward(1.0);
        }

        else {
            dragon(n-1);
            turtle.turnLeft(90);
            nogard(n-1);
        }
    }
   
    // reverse dragon curve of order n
    public void nogard(int n) {
        if (n == 0) {
            turtle.goForward(1.0);
        }
        else {
            dragon(n-1);
            turtle.turnLeft(-90);
            nogard(n-1);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (n < 0 || n > 15) {
            StdOut.println("Try a number between 1 and 15 next time.");
            return;
        }
        new Dragon(n);
    }

}