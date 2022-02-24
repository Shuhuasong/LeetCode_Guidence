package Prefix_Sum.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _1442_CountTripletsThatCanFormTwoArraysOfEqualXOR {

    public int countTriplets(int[] arr) {
        int n = arr.length, res = 0;
        //key: preSum, value : occurence
        Map<Integer, Integer> count = new HashMap<>();
        //key: preSum, previous preSum's relative index for count the number of elem in between when there is nex same preSum
        Map<Integer, Integer> sumToPos = new HashMap<>();
        count.put(0, 1); sumToPos.put(0, -1);
        int sum = 0;
        for(int i=0; i<n; i++){
            sum ^= arr[i];
            System.out.println(sum);
            if(sumToPos.containsKey(sum)){
                res += count.get(sum) * (i-1) - sumToPos.get(sum);
            }
            sumToPos.put(sum, sumToPos.getOrDefault(sum, 0)+i);
            count.put(sum, count.getOrDefault(sum, 0)+1);
        }
        return res;
    }

    /*
      //Prefix XOR, time = O(n^2),Space = O(n)
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n+1];
        prefix[0] = 1;
        for(int i=0; i<n; i++){
            prefix[i+1] = prefix[i]^arr[i];
        }
        int res = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<=n; j++){
                if(prefix[i]==prefix[j]){
                    res += j-i-1;
                }
            }
        }
        return res;
    }
    */

}

/*
Solution 1: Brute Force (TLE)
    Time = O(n^4), Space = O(1)

Solution 2: Brute force with Prefix
    Time = O(n^3), Space = O(n)
    prefix = 0;
    prefix[i] = A[0]^A[1]^....A[i-1];
    for each pair (i, j), we can find if A[i]^..^.A[j] == A[j+1]^....A[k]
    by compare prefix[j]^prefix[i]==prefix[k]^prefix[j+1]

Solution 3: Prefix XOR, time = O(n^2),Space = O(n)
   x = A[i] ^ A[i+1] ^ .... A[j]
   y = A[j+1] ^ A[j+1] ^ ... A[k]
  if(x==y), then  x ^ x = y ^ x, so  y^x = 0
  so: A[i] ^ A[i+1] ^ .... A[j] ^ A[j+1] ^ A[j+1] ^ ... A[k] = 0
   where prefix[k+1] == prefix[i]

   then, we need to find how many pair (i, k) that prefix value are equal.
   we can calculate the prefix array first, then brute force count the pair.
   Once we find, then res += k-i-1, because we can take any middle point in between (i,k)
       to make these two intervals

Solution4: Prefix OXR, One Pass===> HashMap + prefix
    we can reduce the problem to :
    find out the sum of index distance with prefix[i] = prefix[j]


本题是说，问有多少个相邻的子区间对[i:j]和[j+1:k]，使得这两个子区间的亦或和相等。

这个问法其实非常巧妙。如果[i:j]和[j+1:k]的亦或和相等，那么这个大区间[i:k]的亦或和就一定等于零。
而这个亦或和等于零的区间[i:k]，你从任意位置去分成两部分，这两个子区间的亦或和又肯定是相等的。

于是这道题等价于，问有多少个区间的亦或和等于0. 对于每一个符合的区间[i:k]，
只要令j为i+1到k任意一个位置，都可以满足xor[i:j]==xor[j+1:k]。也就是说，
对于符合条件的(i,k)，存在k-i个拆分方法，得到符合条件的(i,j,k)。
对于求亦或和为0的子区间，就是常见的Hash+Prefix的套路。

e.g
arr    =  {2,3,1,6,7,2,3,4}
prefix ={0,2,1,0,6,1,3,0,4}

sumToPos           count
(0, -1)->(0,1)     (0,1)->(0, 2)
(2,0)              (2, 1)
(1, 1)->(1,5)      (1, 1)->(1, 2)
(6, 3)             (6, 1)
(3, 5)             (3, 1)

res  += 1 * (2-1) - (-1)  = 2
     += 1 * (4-1) - 1  = 2
     += 2 * (6-1) - 1 = 9
res = 13
*/
