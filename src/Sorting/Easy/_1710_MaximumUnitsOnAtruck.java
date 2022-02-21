package Sorting.Easy;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _1710_MaximumUnitsOnAtruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b)->b[1]-a[1]);
        int numUnit = 0;
        for(int[] boxType : boxTypes){
            if(boxType[0]<= truckSize){
                truckSize -= boxType[0];
                numUnit += boxType[0] * boxType[1];
            }else{
                numUnit += truckSize * boxType[1];
                truckSize = 0;
                break;
            }

        }
        return numUnit;
    }
}
