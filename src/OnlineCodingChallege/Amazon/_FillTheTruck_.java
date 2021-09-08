package OnlineCodingChallege.Amazon;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
/*
You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes,
boxTypes[i] = [numberOfBoxes, numberOfUnitsPerBox]
numberOfBoxes: the number of boxes of type i.
numberOfUnitsPerBox; is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can
be put on the truck. You can choose any boxes to put on the truck as long as the number of
boxes does not exceed truckSize.
Example 1:
  input : boxTypes = { {1, 3}, {2, 2}, {3, 1}}, truckSize = 4
  output: 8
Example:
  input:  boxTypes = { {5, 10}, {2, 5}, {4, 7}, {3, 9} } , truckSize = 10
  output: 91
 */
public class _FillTheTruck_ {

  /*  public static int maximumUnits(int[][] boxTypes, int truckSize){
        Arrays.sort(boxTypes, (a, b)->b[1]-a[1]);
        int res = 0, boxCnt = 0;
        for(int[] boxT : boxTypes){
            if(boxT[0]+boxCnt <= truckSize){
                res += boxT[0] * boxT[1];
                boxCnt += boxT[0];
            }else{
                int numBox = truckSize - boxCnt;
                System.out.println("numBox = " + numBox);
                res += numBox * boxT[1];
                boxCnt += numBox;
            }
        }
        return res;
    } */

    public static int maximumUnits(int[][] boxTypes, int truckSize){
        Arrays.sort(boxTypes, (a, b)->b[1]-a[1]);
        int res = 0;
        for(int[] b : boxTypes){
            int count = Math.min(b[0], truckSize);
            res += count * b[1];
            truckSize -= count;
            if(truckSize==0) return res;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] boxTypes1 = { {1, 3}, {2, 2}, {3, 1}};
        int[][] boxTypes2 = { {5, 10}, {2, 5}, {4, 7}, {3, 9} };
        System.out.println(maximumUnits(boxTypes1, 4));
        System.out.println(maximumUnits(boxTypes2, 10));
    }
}
