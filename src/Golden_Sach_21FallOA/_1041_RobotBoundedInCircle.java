package Golden_Sach_21FallOA;

/**
 * Created by Shuhua Song
 */
public class _1041_RobotBoundedInCircle {

    public boolean isRobotBounded(String instructions) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;
        int dirt = 0; // face north
        for(char d : instructions.toCharArray()){
            if(d=='L'){
                dirt = (dirt + 3) % 4;
            }else if(d=='R'){
                dirt = (dirt + 1) % 4;
            }else{
                x += directions[dirt][0];
                y += directions[dirt][1];
            }
        }
        return (x==0 && y==0) || (dirt != 0);
    }
}
