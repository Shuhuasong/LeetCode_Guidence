package Golden_Sach_21FallOA;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _DoubleOnMatch_ {

    private static int maxNum(int[] arr, int num){
        if(arr==null || arr.length==0) return num;
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            if(arr[i]==num){
                num = 2 * num;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 11, 12, 8};
        int num = 2;
        System.out.println(maxNum(arr, num));
    }
}
