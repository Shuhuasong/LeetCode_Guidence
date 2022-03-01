package BinarySearch.Easy;

/**
 * Created by Shuhua Song
 */
public class _441_ArrangingCoins {
    public int arrangeCoins(int n) {
        if (n < 2) return n;
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sum = (long) mid * (mid + 1) / 2;
            if (sum <= n) left = mid + 1;
            else {
                right = mid - 1;
            }
            //System.out.println(left + " " + right + " " + mid);
        }
        return right;
    }
}
