package BinarySearch.Medium;

public class _875_KoKoEatingBananas {
    //Time = O(n log P) Space = O(1)
    public int minEatingSpeed(int[] piles, int H) {
        int start = 1, end = Integer.MAX_VALUE;
        int result = 0;
        while(start <= end){
            int totalHour = 0;
            int mid = start+(end-start)/2;
            totalHour = getTotalHour(piles, mid);
            if(totalHour <= H){
                end = mid-1;
                result = mid;
            }else {
                start = mid+1;
            }
        }

        return result;
    }


    private int getTotalHour(int[] piles, int speed){
        int totalHour = 0;
        for(int i=0; i<piles.length; i++){
            totalHour += piles[i]/speed;
            if(piles[i]%speed!=0){
                totalHour++;
            }
        }
        return totalHour;
    }

}
