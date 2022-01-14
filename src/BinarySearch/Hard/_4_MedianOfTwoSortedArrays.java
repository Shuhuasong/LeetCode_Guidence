package BinarySearch.Hard;

/**
 * Created by Shuhua Song
 */
public class _4_MedianOfTwoSortedArrays {
    //Time = O(min(n1, n2))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        //do binary search on smaller array ==> faster
        if(n1 > n2){
            return  findMedianSortedArrays(nums2, nums1);
        }
        int k = (n1+n2+1)/2;
        int l = 0, r = n1;
        //the # elems from nums1
        //Then # elems from nums2
        int m1 = 0;
        int m2 = 0;
        while(l < r){
            m1 = l + (r-l)/2;
            m2 = k - m1;
            if(nums1[m1] < nums2[m2-1]){
                l = m1 + 1;
            }else{
                r = m1;
            }
        }
        m1 = l;
        m2 = k-l;
        //when m1 <= 0, means there is no elems from nums1, return MIN
        int leftMed = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1-1],
                m2 <= 0 ? Integer.MIN_VALUE : nums2[m2-1]);
        if((n1+n2)%2==1) return leftMed;
        //when m1 >= n1, means m1 out of the range, return MAX
        int rightMed = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1],
                m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);
        return (leftMed+rightMed)*0.5;
    }
}

/*
Assuming: n1 = nums1.length, n2 = nums2.length;
case-1:
nums1 : {1, 2, 3}
nums2 :          {4, 5, 6}
Median:        |  |           med = 3.5

case-2:
nums1 : {1, 2}
nums2 :        {3, 4, 5}
Median:         |            med = 3

case-3:
nums1 : {1, 2}
nums2 :        {3, 4, 5, 6}
Median:         |  |           med = 3.5

case-4:
nums1 : {1, 2}
nums2 :       {3, 4, 5, 6, 7}
Median:           |           med = 4

case-5:
nums1 :     {2, 4}
nums2 :  {1, 3, 5}
Median:      |            med = 3

case-6:
nums1 :          {9,10}
nums2 : {2, 4, 6}
Median:        |          med = 6

nums1: {A0, A1, A2, ..., Am1-1, Am1,...An1-1}
nums2: {B0, B1, B2, ..., Bm2-1, Bm2,...Bn2-1}
Merge nums1, nums2:
                    k elem
{C0, C1, C2, ..., Ck-1, Ck, ...,C[n1+n2-1]}  even
                    |    |
{C0, C1, C2, ..., Ck-1, Ck, ...,C[n1+n2-1]}  odd
                    |
take m1 elem from nums1, and take m2 elem from nums2 to form k elems
m1 + m2 = k = (n1+n2+1)/2,
Median must from : {Am1-1, Bm2-1, Am1, Bm2}
!!!-Binary Search m1, based on  A[m1] < B[m2-1] ?
Ck-1 = Math.max(Am1-1, Bm2-1)  left median
Ck   = Math.max(Am1, Bm2)      right median

nums1 :
    0  1  2  3. 4. 5
  {-1, 1, 3, 5, 7, 9}
                |m1
nums2:
   0  1  2  3  4   5   6   7
  {2, 4, 6, 8, 10, 12, 14, 16}
            |m2
n1 = 6, n2 = 8, k = (n1+n2+1)/2 = 7 (#elem before median)
m1 = 4, m2 = 3, finally, need to take m1 from nums1, and m2 from nums2
Ck-1 = Max(Am1-1, Bm2-1)  = max(5, 6) = 5
Ck = Min(Am1, Bm2) = min(7, 8) = 7
median = (Ck-1 + Ck) / 2 = (6+7)/2 = 6.5

l = 0, r = n1 = 6 while(l < r), 使用元素个数
l   r    m1   m2   A[m1]   B[m2]   Compare
0   6    3    4      5       8       < ，use too less elem from nums1, so we need more, shif l = m1 + 1 = 3+1 = 4
4   6    5    2      9       4       > ，use too many elem from nums1, so we need less, shif r = m1 = 5
4   5    4    3      7       6       > ，use too many elem from nums1, so we need less, shif r = m1 = 5
4   4

Note: lots of corner cases
*/

