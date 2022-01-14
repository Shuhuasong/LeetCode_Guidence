package TwoPointer.Medium;

/**
 * Created by Shuhua Song
 */
public class _923_3SumWithMultiplicity {

    //Time = O(n^2), space = O(n)
    public int threeSumMulti(int[] arr, int target) {
        int MOD = (int)1e9+7;
        //use long to avoid overflow when managing count[x]*count[y]*count[z]
        long[] count = new long[101];
        int numDiff = 0;
        for(int a : arr){
            count[a]++;
            if(count[a]==1) numDiff++;
        }
        int[] nums = new int[numDiff];
        int k = 0;
        for(int i=0; i<101; i++){
            if(count[i] > 0){
                nums[k++] = i;
            }
        }
        long res = 0;
        //find 3 sums on leys, for i<=j<=k
        for(int i=0; i<nums.length; i++){
            int x = nums[i];
            int newT = target-x;
            int l = i, r = nums.length-1;
            while(l <= r){
                int y = nums[l], z = nums[r];
                if(y+z < newT){
                    l++;
                }else if(y+z > newT){
                    r--;
                }else{ // x+y+z == T, calc the size of contribution
                    if(i < l && l<r){
                        res += count[x] * count[y] * count[z];
                    }else if(i==l && l < r){
                        res += count[x] * (count[x]-1)/2 * count[z];
                    }else if(i<l && l==r){
                        res += count[x] * count[y] * (count[y]-1)/2;
                    }else{ //i==j==k
                        res += count[x] * (count[x]-1) * (count[x]-2)/6;
                    }
                    res %= MOD;
                    l++;
                    r--;
                }
            }
        }
        return (int)res;
    }
}

/*
idea:
1) if x, y, and z are different: the contribution is:
   count[x] * count[y] * count[z]
2) if x==y != z, the comtributions is : C(count[x], 2) * count[y]
3) if x!=y == z, the contribution is count[x] * C(count[y], 2)
4) if x==y==z, the contribution is C(count[x], 3)

 0  1  2  3  4  5  6  7  8  9
    k
[1, 1, 2, 2, 3, 3, 4, 4, 5, 5]        target = 8
 i                          j

k=1, i=0, j=9 ==> count1=1,


*/


