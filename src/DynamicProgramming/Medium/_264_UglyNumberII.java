package DynamicProgramming.Medium;


//Time = O(1)
//Space = O(1690)
class Ugly{
    public int[] nums = new int[1690];
    public Ugly(){
        nums[0] = 1;
        int ugly, i2 = 0, i3 = 0, i5 = 0;

        for(int i=1; i<1690; i++){
            ugly = Math.min(nums[i2] * 2, Math.min(nums[i3] * 3, nums[i5] * 5));
            nums[i] = ugly;
            if(ugly == nums[i2] * 2) i2++;
            if(ugly == nums[i3] * 3) i3++;
            if(ugly == nums[i5] * 5) i5++;
        }
    }
}

public class _264_UglyNumberII {

    public static Ugly ugly = new Ugly();
    public int nthUglyNumber(int n) {
        return ugly.nums[n-1];
    }

}



/*
class Ugly{
    public int[] nums = new int[1690];
    public Ugly(){
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        pq.add(1L);
        seen.add(1L);
        int k=0;
        int[] factors = {2, 3, 5};
        long curUgly = 0, newUgly = 0;
        for(int i=0; i<1690; i++){
            curUgly = pq.poll();
            nums[k++] = (int)curUgly;
            for(int f : factors){
                newUgly = curUgly * f;
                if(!seen.contains(newUgly)){
                    pq.add(newUgly);
                    seen.add(newUgly);
                }
            }
        }
    }
}


class Solution {
    public static Ugly ugly = new Ugly();
    public int nthUglyNumber(int n) {
          return ugly.nums[n-1];
     }
}
*/