package HashTable.Medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.util.*;
import java.io.*;
import  java.util.Arrays.*;
class Main {
    /**
     There is a rectangular brick wall in front of you with n rows of bricks. The ith row has some number of bricks each of the same height (i.e., one unit) but they can be of different widths. The total width of each row is the same.

     Draw a vertical line from the top to the bottom and cross the least bricks. If your line goes through the edge of a brick, then the brick is not considered as crossed. You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.

     Given the 2D array wall that contains the information about the wall, return the minimum number of crossed bricks after drawing such a vertical line.

     */
    public static int leastBricks(List<List<Integer>> wall) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(List<Integer> currWall : wall) {

            int edge=0;

            for(int i=0; i<currWall.size()-1; i++) {
                int curr=currWall.get(i);
                edge=edge+curr;
                map.put(edge, map.getOrDefault(edge, 0)+1);
            }
        }

        int max=0;

        for(Integer key : map.keySet()) {
            max=Math.max(max, map.get(key));
        }

        return wall.size()-max;

    }


    public static void main(String[] args) {
        /* Sumukh */

        Integer[][] walls={{1},{1},{1}};
        List<List<Integer>> wall = new ArrayList<>();

        for(Integer[] wallArray : walls) {
            List<Integer> tempList= Arrays.asList(wallArray);
            wall.add(tempList);
        }

        int result = leastBricks(wall);
        System.out.println("result = " + result);
    }
}
/*
public class _554_BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        int rows = wall.size();
        // if(rows==0) return 0;
        // if(wall.get(0).size()==1) return rows;
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> list : wall){
            int sum = 0; // sum: record the position of gap for every brick in each row
            for(int i=0; i<list.size()-1; i++){
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        int res = rows;
        for(int key : map.keySet()){
            res = Math.min(res, rows-map.get(key));
        }
        return res;
    }
}
*/