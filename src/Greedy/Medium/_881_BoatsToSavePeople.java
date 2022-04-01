package Greedy.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _881_BoatsToSavePeople {
    //Time = O(nlogn), Space =O(1)
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0, n = people.length;
        int left = 0, right = n-1;
        while(left <= right){
            if(people[left]+people[right] > limit){
                count++;
                right--;
            }else{
                count++;
                left++;
                right--;
            }
        }
        return count;
    }
}
