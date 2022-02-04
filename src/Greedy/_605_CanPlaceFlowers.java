package Greedy;

/**
 * Created by Shuhua Song
 */
public class _605_CanPlaceFlowers {
    //Mark on the original array
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0, len = flowerbed.length;
        int i = 0;
        while(i < len){
            if(flowerbed[i]==0 && (i==0 || flowerbed[i-1]==0) && (i==len-1 || flowerbed[i+1]==0)){
                count++;
                flowerbed[i] = 1;
            }
            if(count >= n) return true;
            i++;
        }
        return false;
    }

    /*
     //With modify the original array
    //Set up a prevSit to check if the seat in the previous position is 1 or 0
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0, len = flowerbed.length;
        int prevSit = -1;
        for(int i=0; i<len; i++){
            if(flowerbed[i]==0 && (i==0 || flowerbed[i-1]==0) && (i==len-1 || flowerbed[i+1]==0)){
                count++;
                prevSit = i;
                i++;
                continue;
            }
            if(flowerbed[i]==1) prevSit = i;
        }
        return count>=n;
    }
     */
}
