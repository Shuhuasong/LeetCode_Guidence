package TwoPointer.Medium;

/**
 * Created by Shuhua Song
 */
public class _556_NextGreaterElement_III {
    public int nextGreaterElement(int n) {
        String s = n + "";
        char[] chs = s.toCharArray();
        int m = chs.length, i = m-2;
        //from right to left, find the first char whichis in decreasing
        while(i>=0 && chs[i]>=chs[i+1]){
            i--;
        }
        //not the find the char, n = 4321
        if(i<0) return -1;
        //from right to left, find the first char which is greater than chs[i]
        int r = m-1;
        while(r>=i && chs[r]<=chs[i]){
            r--;
        }
        //swap the two digits, to get greater number than n
        swap(chs, i, r);
        //reverse the number afer i+1, to get smallest number but greater than n
        reverse(chs, i+1);
        //the res may exceed the Integer range, so use long type
        long res = Long.parseLong(new String(chs));
        return res > Integer.MAX_VALUE ? -1 : (int)res;
    }

    private void reverse(char[] f, int start){
        int l=start, r=f.length-1;
        while(l<r){
            swap(f, l, r);
            l++;
            r--;
        }
    }
    private void swap(char[] f, int i, int j){
        char tmp = f[i];
        f[i] = f[j];
        f[j] = tmp;
    }
}


/*
Solution:
case-1: if the n = 4321, it is not possible to get a larger number by swap
case-2: if
                r
    n = 1 5 8 4 7 6 5 3 1
              | find decreasig elment(4)
    move r pointer to find number just larger than 4


Why do you have to walk from right to left? Because we want the least significant digit that is greater than the current number.
Why do you have to find a[j] and swap? We're trying to find a digit which is only 1 distance greater than a[i-1] so that this can become new number and is 1 greater than the new dip.
Why do you have to reverse? We're trying to make this number as small as possible. Because we know that the sequence is increasing from right to left in step 1, we can reverse it to be a increasing sequence from left to right.

*/