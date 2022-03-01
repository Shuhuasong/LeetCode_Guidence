package TwoPointer.Medium;

/**
 * Created by Shuhua Song
 */
public class _11_ContainerWithMostWater {

    public int maxArea(int[] h) {
        if(h==null || h.length==0) return 0;
        int maxArea = 0, n = h.length;
        int left = 0, right = n-1;
        while(left < right){
            maxArea = Math.max(maxArea, (right-left) * Math.min(h[left], h[right]));
            if(h[left] <= h[right]) left++;
            else{
                right--;
            }
        }
        return maxArea;
    }

    /* //TLE
    public int maxArea(int[] h) {
        int n = h.length;
        int l = 0, r = n-1;
        int maxArea = 0, currArea = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                maxArea = Math.max(maxArea, Math.min(h[i], h[j])*(j-i));
            }
        }
        return maxArea;
    } */
}

/*
算法：双指针。
让左指针指向0，右指针指向height.size()-1。每次考虑如果减少横向距离1，判断应该选择移左指针还是右指针，还是考察both？

事实上，只需要移动height[left]和height[right]中较矮的一个板子即可，这样才有使总面积增大的可能。否则移动较高的板子，
不会使结果变得更好，因为面积受限于较矮的那块板子。

if (height[left] <= height[right])
   left++;
else
   right--;
 */