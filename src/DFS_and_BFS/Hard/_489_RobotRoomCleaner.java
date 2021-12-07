package DFS_and_BFS.Hard;

import java.awt.*;
import java.util.HashSet;

/**
 * Created by Shuhua Song
 */
public class _489_RobotRoomCleaner {
    // This is the robot's control interface.
  // You should not implement it, or speculate about its implementation
          interface Robot {
      // Returns true if the cell in front is open and robot moves into the cell.
              // Returns false if the cell in front is blocked and robot stays in the current cell.
              public boolean move();

              // Robot will stay in the same cell after calling turnLeft/turnRight.
              // Each turn will be 90 degrees.
              public void turnLeft();
      public void turnRight();

             // Clean the current cell.
             public void clean();
  }

    //0: up, 1:right, 2:down, 3:left
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public void cleanRoom(Robot robot) {
        backtrack(0, 0, 0, new HashSet<>(), robot);
    }

    private void backtrack(int i, int j, int face, HashSet<String> visited, Robot robot){
        // if(visited.contains(i+","+j)) return;
        visited.add(i+","+j);
        robot.clean();
        for(int k=0; k<4; k++){
            int nx = i + dirs[face][0];
            int ny = j + dirs[face][1];
            if(!visited.contains(nx+","+ny)  && robot.move()){
                backtrack(nx, ny, face, visited, robot);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
            face = (face+1)%4;
        }
    }
}
