package Sorting.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _1996_TheNumberOfWeakCharactersInTheGame {

    //Sort the array according to descending order of attack
    //if attack are the same, order the defense acending order
    //Define a variable to track the max previous defense
    //Time = O(n*logn)
    public int numberOfWeakCharacters(int[][] props) {
        Arrays.sort(props, (a, b)->{
            if(a[0] != b[0]) return b[0]-a[0];
            else
                return a[1]-b[1];
        });
        int res = 0, n = props.length;
        int maxDef = props[0][1];
        for(int i=1; i<n; i++){
            if(props[i][1] < maxDef){
                res++;
            }
            maxDef = Math.max(maxDef, props[i][1]);
        }
        return res;
    }
}
