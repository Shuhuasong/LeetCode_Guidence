package OnlineCodingChallege.Citadel;

/**
 * Created by Shuhua Song
 */
public class _DoTheyBelong {

    private static int pointsBelong(int x1, int y1, int x2, int y2, int x3, int y3, int px, int py, int qx, int qy){
        if(!isTriangle(x1, y1, x2, y2, x3, y3)){
            return 0;
        }
        boolean p = isInside(x1, y1, x2, y2, x3, y3, px, py);
        boolean q = isInside(x1, y1, x2, y2, x3, y3, qx, qy);
        if(p && !q) return 1;
        if(!p && q) return 2;
        if(p && q) return 3;
        return 4;
    }

    private static boolean isInside(int x1, int y1, int x2, int y2, int x3, int y3, int px, int py){
        double  entireArea = area(x1, y1, x2, y2, x3, y3);
        double  A1 = area(x1, y1, x2, y2, px, py);
        double  A2 = area(x1, y1, x3, y3, px, py);
        double  A3 = area(x2, y2, x3, y3, px, py);
        return (entireArea==A1+A2+A3);
    }
  //area of the triangle ABC in the above diagram. Area A = [ x1(y2 – y3) + x2(y3 – y1) + x3(y1-y2)]/2
    private static double area(int x1, int y1, int x2, int y2, int x3, int y3){
        return 0.5 * Math.abs(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2));
    }

    private static boolean isTriangle(int x1, int y1, int x2, int y2, int x3, int y3){
        double d1 = distance(x1, y1, x2, y2);
        double d2 = distance(x2, y2, x3, y3);
        double d3 = distance(x1, y1, x3, y3);
        return (d1+d2 > d3) && (d2 + d3 > d1) && (d1 + d3 > d2);
    }

    private static double distance(int x1, int y1, int x2, int y2){
        return Math.sqrt((Math.pow(x2-x1, 2)) + Math.pow(y2-y1, 2));
    }

    public static void main(String[] args) {
        System.out.println(pointsBelong(2,2,7,2,5,4,4,3,7,4));
        System.out.println(pointsBelong(0,0,2,0,4,0,2,0,4,0));
    }
}
