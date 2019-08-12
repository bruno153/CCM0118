/******************************************************************************
 *  Compilation:  javac PercDephPlot.java
 *  Execution:    java PercDephPlot N
 *
 *  This recursive program draws a plot of the percolation deph
 *  (experimental observation) against the site vacancy probability
 *  (control variable).
 *
 *  % java PercDephPlot N
 *
 ******************************************************************************/

public class PercDephPlot {

    // recursive curve plotting
    public static void curve(int N, double x0, double y0, double x1, double y1) {
        double gap = .01;
        double err = .0025;
        int M = 10000;
        double xm = (x0 + x1) / 2;
        double ym = (y0 + y1) / 2;
        double fxm = Estimate.evalDeph(N, xm, M);
        if (x1 - x0 < gap || Math.abs(ym - fxm) < err) {
            StdDraw.line(x0, y0, x1, y1);
            return;
        }
        curve(N, x0, y0, xm, fxm);
        StdDraw.filledCircle(xm, fxm, .005);
        curve(N, xm, fxm, x1, y1);
    }

    // test client
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
		StdDraw.setYscale(-1, N-1);
        PercDephPlot.curve(N, 0.0, -1, 1.0, N-1);
    }
}