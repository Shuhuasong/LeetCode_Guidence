package OnlineCodingChallege.Amazon;

/**
 * Created by Shuhua Song
 */

/*
 最多执行几遍系列指令能判断是否转圈
 执行一遍系列指令导致转圈的条件是：
  1） 执行完一遍指令后回到原点
  2） 执行完一遍指令后发生转向 （因为只有两个方向， 角度分别为 90，180， 270 ）
 Solution:
   通过变量 x, y 表示距离原点的位移， 通过direction 表示朝向， 同时也是单位位移数组的index
   directions 的值 0， 1， 2， 3。 分别表示  north, west, south. east
   {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}
   遍历 instructions， 对于每一个指令， 改变对应的 x, y 和 direction
   最终只需要判断是否是 x, y 都是 0， 或者 direction 不为 0 即可

   Time= O(n)  Space = O(1)
*/
public class _1041_RobotBoundedInCircle {

    public boolean isRobotBounded(String instructions){
        int[][] directions = new int[][]{ {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;
        int dirt = 0;
        for(char d : instructions.toCharArray()){
           if(d=='G'){
               x += directions[dirt][0];
               y += directions[dirt][1];
           }else if(d=='L'){ // d = west = 1
               dirt = (dirt+1) % 4;
           }else{ //d = 'R' == east = 3
               dirt = (dirt+3) % 4;
           }
        }
        return (x==0 && y==0) || (dirt != 0);
    }
}
