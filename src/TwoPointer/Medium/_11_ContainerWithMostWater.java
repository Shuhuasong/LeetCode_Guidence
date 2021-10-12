package TwoPointer.Medium;

/**
 * Created by Shuhua Song
 */
public class _11_ContainerWithMostWater {
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
    }
}
