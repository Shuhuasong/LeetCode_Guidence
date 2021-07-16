package Stack.Hard;

import java.util.Stack;

public class _768_MaxChunksToMakeSortedII {
    //Solution: Stack--keep a monostack
    //Time = O(n) Space = O(n)
    public int maxChunksToSorted(int[] arr) {
        if(arr.length==0) return 0;
        int curMax = Integer.MIN_VALUE, res = 0, n = arr.length;
        Stack<Integer> stack = new Stack<>();
        for(int num : arr){
            if(stack.isEmpty() || stack.peek() < num){
                stack.push(num);
                curMax = Math.max(curMax, num);
            }else{
                while(!stack.isEmpty() && stack.peek() > num){
                    stack.pop();
                }
                stack.push(curMax);
            }
        }
        return stack.size();
    }
                /*
            ....3, [7, 8, 4, 6, 5], 9....
            curMax = 8
            ....3
            ....3, 7
            ....3, 7, 8
            ....3, 8
            ....3, 8
            ....3 ,8
            ....3, 8, 9,....
            */



    /*
      //Solution: PreSum
    //Time = O(n) Space = O(n)
    public int maxChunksToSorted(int[] arr) {
          if(arr.length==0) return 0;
        int maxVal = 0, res = 0, n = arr.length;
        int[] nums = new int[n];
        int k = 0;
        for(int a : arr) nums[k++] = a;
        Arrays.sort(nums);
        int sum1 = 0, sum2 = 0;
        for(int i=0; i<n; i++){
            sum1 += nums[i];
            sum2 += arr[i];
            if(sum1==sum2){
                res += 1;
            }
        }
        return res;
    }

    /*
     arr =  {5, 4, 3, 2, 1}
     sum     5  9  12 14 15
     nums = {1, 2, 3, 4, 5}
             1, 3, 6, 10, 15

    */


}
