package Golden_Sach_21FallOA;

import java.util.PriorityQueue;

/**
 * Created by Shuhua Song
 */
/*
processes scheduling
题目是给一个数组比如[3,1,7,2,4], 还有一个input叫processes=15. 从数组中选择可以选择的最大的数，然后processes减去这个数，并且这个数要取一半再放回数组中去。
第一个可以选择的是7， processes 15 - 7 = 8， 7/2 = 3, 把3放回到原数组中，做下一轮操作。
第二个可以选择的是4， processes 8 - 4 = 4， 4/2 = 2， 把2放回到原数组中做下一轮操作。以此类推。

求，一共进行多少次这样的操作，processes最终为0。 这个example的ouput是4次。
我是用的heap做的。

 */
public class ProcessSchedule {

    private static int numOperate(int[] nums, int process){
        if(nums==null || nums.length==0 || process==0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        for(int a : nums) pq.add(a);
        int res = 0;
        while(!pq.isEmpty() && process > 0){
            int maxVal = pq.poll();
            process = process - maxVal;
            int newNum = maxVal/2;
            pq.add(newNum);
            res++;
            System.out.println(process + " " + maxVal + " " + newNum + " " + res);
        }
        return res;
    }

    public static void main(String[] args) {
          int[] nums = {3, 1, 2, 4, 7};
          int process = 15;
        System.out.println(numOperate(nums, process));
    }
}
