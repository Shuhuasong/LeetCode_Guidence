package TwoPointer.Medium;

public class _80_RemoveDuplicatesInSortedArrayII {

    //Overwrite unwanted duplicate
    //Time = O(n) Space = O(1)
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int n = nums.length, j = 1, count = 1;
        //start from the second element
        for(int i=1; i<n; i++){
            if(nums[i]==nums[i-1]){
                //if the current element is a duplicate, increment the coutn
                count++;
            }else{
                //reset the count when encounter a different element
                count = 1;
            }
            //for count<=2, we copy the right element at left pointer
            if(count<=2){
                //reset th
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public int[] remElement(int[] arr, int index) {

        //
        // Overwrite the element at the given index by
        // moving all the elements to the right of the
        // index, one position to the left.
        //
        for (int i = index + 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }

        return arr;
    }

    /*
We define two pointers, l and r for our algorithm. The pointer r iterates of the array processing one element at a time and l keeps track of the next location in the array where we can overwrite an element.

We also keep a variable count which keeps track of the count of a particular element in the array. Note that the minimum count would always be 1.

We start with index 1 and process one element at a time in the array.

If we find that the current element is the same as the previous element i.e. nums[i] == nums[i - 1], then we increment the count. If the value of count > 2, then we have encountered an unwanted duplicate element. In this case, we simply move forward i.e. we increment r but not l.

However, if the count is <= 2, then we can move the element from index r to index l.
*/


 /*   public int removeDuplicates(int[] nums) {

        // Initialize the counter and the array index.
        int i = 1, count = 1, length = nums.length;

        // Start from the second element of the array and process
        // elements one by one.

        while (i < length) {

            // If the current element is a duplicate,
            // increment the count.
            //
            if (nums[i] == nums[i - 1]) {
                count++;
                // If the count is more than 2, this is an unwanted duplicate element
                // and hence we remove it from the array.
                //
                if (count > 2) {
                    this.remElement(nums, i);

                    // Note that we have to decrement the array index value to
                    // keep it consistent with the size of the array.
                    i--;
                    //
                    // Since we have a fixed size array and we can't actually
                    // remove an element, we reduce the length of the array as
                    // well.
                    //
                    length--;
                }
            } else {
                // Reset the count since we encountered a different element
                // than the previous one.
                //
                count = 1;
            }

            // Move on to the next element in the array
            i++;
        }

        return length;
    } */

   }
