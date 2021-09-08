package Array.Easy;

/**
 * Created by Shuhua Song
 */
public class _1287_ElementAppearingMoreThan25PercentInSortedArray {

    public int findSpecialInteger(int[] arr) {
        if(arr==null || arr.length==0) return -1;
        int n = arr.length;
        if(n==1) return arr[0];
        int count = 1, prev = arr[0];
        for(int i=1; i<n; i++){
            if(arr[i]==prev){
                count++;
                if(count > n/4) return arr[i];
            }else{
                prev = arr[i];
                count = 1;
            }
        }
        return -1;
    }
}
