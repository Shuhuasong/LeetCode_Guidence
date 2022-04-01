package TwoPointer.Medium;

/**
 * Created by Shuhua Song
 */
public class _287_FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while(nums[i] > 0){
            nums[i] = -nums[i];
            i = Math.abs(nums[i]);
        }
        return i;
    }

    /*
     public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length;
        while(left < right){
            int k = left + (right-left)/2;
            int count = 0;
            for(int num : nums){
                if(num<=k) count++;
            }
            if(count > k){
                right = k;
            }else{
                left = k + 1;
            }
        }
        return left;
    }
     */
}

/*
Solution-1: Binary Search
本题数的范围是1~n，但是数的个数有n+1个，说明duplicated number至少出现了两次。但是duplicated number也有可能出现的次数更多，它或许会替代了某些missing numbers.但不管怎样，duplicated number的出现次数一定比missing numbers更多。这样，如果k是那个duplicated number的话，我们遍历数组统计小于等于k出现的次数一定是大于k的。

我们就可以用这个判据去二分搜值。我们猜测一个数k，如果小于等于k出现的次数大于k，那么k有可能是答案，但也有可能比它更小，故right=k. 反之，那么k一定不是答案，我们必须提升答案区间的下限，即left=k+1.

Solution-2: slow-fast pointer
此题还有一个非常绝妙的算法。将1~N个数放在N+1个位置上，那么val->index将会出现一个一对多的映射，反之，index->val将会有一个多对一的映射。而其余的则是一一映射。于是这些index和val势必会有一部分构成一个环。

举个例子：2,4,1,3,1 从index到val的映射关系是：1->2, 2->4, {3,5}->1, 4->3，其中1->2->4->3->1就构成了一个环。对于这个环，我们看到多出了一条5->1的切入口。可见，这个环的额外入口就是重复的数字。

于是此题可以联想到 142. Linked List Cycle II，用快慢指针来确定一个linked list中环的入口。算法是，先用快慢指针做追及（快指针的速度比慢指针快一倍），直到他们相遇的位置；再用一个慢指针从起点开始，和在追及位置的慢指针共同前进。他们再次相遇的地方就是环的入口。
*/
