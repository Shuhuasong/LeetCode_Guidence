package Array.Medium;

import java.util.Arrays;

public class _611_ValidTriangleNumber {


    // Assume  c is the longest edge, a and b are shorter, then we need satisfy : len(a) + len(b) > len(c)
    public int triangleNumber(int[] nums) {
        int count = 0, n = nums.length;
        Arrays.sort(nums);
        for(int end=2; end<n; end++){
            int left = 0, right = end-1;
            while(left < right){
                if(nums[left]+nums[right] > nums[end]){
                    count += right-left;
                    right--;
                }else{
                    left++;
                }
            }
        }
        return count;
    }

    /*
    /*
public static int triangleNumber(int[] A) {
    Arrays.sort(A);
    int count = 0, n = A.length;
    for (int i=n-1;i>=2;i--) {
        int l = 0, r = i-1;
        while (l < r) {
            if (A[l] + A[r] > A[i]) {
                count += r-l;
                r--;
            }
            else l++;
        }
    }
    return count;
}*/





    //Linear Scan Time = O(n^2)  Space = O(log n)
 /*   public int triangleNumber(int[] nums) {
        int result = 0, n = nums.length;
        Arrays.sort(nums);

        for(int i=0; i<n-2; i++){
            int k = i+2;
            for(int j=i+1; j<n-1 && nums[i]!=0; j++){
                while(k<n && nums[i]+nums[j] > nums[k]){
                    k++;
                }
                result += k-j-1;
            }
        }
        return result;
    } */
}

/*
the condition for forming a triangle: a+b > c
1) Sort the array
2) fix the first two elem first, with pair (x, y);
   hten find the right limit by move k forward until the
   condition is not satisfy(a+b==c).

0  1 2 3
[2,2,3,4,6, 7,8]
 |

 */
