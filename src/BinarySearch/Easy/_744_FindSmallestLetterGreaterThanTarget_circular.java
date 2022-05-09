package BinarySearch.Easy;

/**
 * Created by Shuhua Song
 */
public class _744_FindSmallestLetterGreaterThanTarget_circular {
    /*
    Solution-1: linear scan
    Solution-2: Binary Search
    find something larger than target in a sorted array==> Binary Search
    == find the rightmost position to insert target into letters
    == must use condition(left < right)
    == at the end, if our insertion position is n, then return letters[0].
       This is what the modulo operation does
    */
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int left = 0, right = n;
        while(left < right){
            int mid = left + (right-left)/2;
            if(letters[mid] > target){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return letters[left%n];
    }
    /*
     public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int left = 0, right = n;
        while(left+1 < right){
            int mid = left + (right-left)/2;
            if(letters[mid] > target){
                right = mid;
            }else{
                left = mid;
            }
        }
        if(letters[left%n]>target) return letters[left%n];
        return letters[right%n];
    }
     */
}
