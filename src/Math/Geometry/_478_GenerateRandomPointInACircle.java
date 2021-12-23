package Math.Geometry;

import java.util.Random;

/**
 * Created by Shuhua Song
 */
public class _478_GenerateRandomPointInACircle {
    Random rand = new Random();
    double rad, xc, yc;
    public _478_GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
        this.rad = radius;
        this.xc = x_center;
        this.yc = y_center;
    }

    public double[] randPoint() {
        double x0 = xc - rad;
        double y0 = yc - rad;
        while(true){
            //Generate random number between x0 to 2R
            double x = x0 + 2 * rad * rand.nextDouble();
            double y = y0 + 2 * rad * rand.nextDouble();
            double dist = Math.sqrt((x-xc)*(x-xc) + (y-yc)*(y-yc));
            if(dist <= rad){
                return new double[]{x, y};
            }
        }
    }
}
