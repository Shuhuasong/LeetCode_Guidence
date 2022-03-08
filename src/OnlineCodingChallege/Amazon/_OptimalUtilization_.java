package OnlineCodingChallege.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shuhua Song
 */
//Device Application Pairs / Optimal Amazon Air Route / Optimal Utilization

// input: deviceCapacity = 7, foregroundAppList = [[1,2],[2,4],[3,6]], backgroundAppList = [[1,2]]  数组里的第一个数算是index，第二个是value
// output: 从f 和 b里面选出value和不超过deviceCapacity，尽量接近deviceCapacity 的组合的index， 上面的例子的结果是 [1,2]。
// 题不难，就是要注意是要求出所有组合，比如：
// input: deviceCapacity=30, foregroundAppList = [[1,11],[2,11],[3,11]], backgroundAppList = [[1,9],[2,9]]
// 返回的值是 [[1,1],[2,1],[3,1],[1,2],[2,2],[3,2]]

/*
Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value. Your task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible. Return a list of ids of selected elements. If no pair is possible, return an empty list.

Example 1:

Input:
a = [[1, 2], [2, 4], [3, 6]]
b = [[1, 2]]
target = 7

Output: [[2, 1]]

Explanation:
There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum of 4, 6 and 8, respectively.
Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.
Example 2:

Input:
a = [[1, 3], [2, 5], [3, 7], [4, 10]]
b = [[1, 2], [2, 3], [3, 4], [4, 5]]
target = 10

Output: [[2, 4], [3, 2]]

Explanation:
There are two pairs possible. Element with id = 2 from the list `a` has a value 5, and element with id = 4 from the list `b` also has a value 5.
Combined, they add up to 10. Similarily, element with id = 3 from `a` has a value 7, and element with id = 2 from `b` has a value 3.
These also add up to 10. Therefore, the optimal pairs are [2, 4] and [3, 2].
Example 3:

Input:
a = [[1, 8], [2, 7], [3, 14]]
b = [[1, 5], [2, 10], [3, 14]]
target = 20

Output: [[3, 1]]
Example 4:

Input:
a = [[1, 8], [2, 15], [3, 9]]
b = [[1, 8], [2, 11], [3, 12]]
target = 20

Output: [[1, 3], [3, 2]]
 */

public class _OptimalUtilization_ {
    public static List<List<Integer>> closestSum(List<List<Integer>> listA, List<List<Integer>> listB, int target){
        listA.sort((a, b)->a.get(1).compareTo(b.get(1)));
        listB.sort((a, b)->a.get(1).compareTo(b.get(1)));
        int sizeA = listA.size(), sizeB = listB.size();
        int pa = 0, pb = sizeB-1;
        int closeSum = Integer.MIN_VALUE;
        List<List<Integer>> results = new ArrayList<>();
        List<List<Integer>> temp = new ArrayList<>();
        while(pa < sizeA && pb >= 0){
            List<Integer> valA = listA.get(pa);
            List<Integer> valB = listB.get(pb);
            int sum = valA.get(1) + valB.get(1);
            if(sum > target){
                pb--;
            }else {
                //with greater sum that is closer to target
                if(closeSum < sum){
                    closeSum = sum;
                    temp.clear();
                    temp.add(Arrays.asList(valA.get(0), valB.get(0)));
                }else if(sum==closeSum){
                //with the same sum from previous result, add them together
                    temp.add(Arrays.asList(valA.get(0), valB.get(0)));
                }
                pa++;
            }
        }
        results.addAll(temp);
        return results;
    }
    public static void main(String[] args) {
        List<List<Integer>> listA = new ArrayList<List<Integer>>();
        List<List<Integer>> listB = new ArrayList<List<Integer>>();
        listA.add(new ArrayList<Integer>(Arrays.asList(1, 8)));
        listA.add(new ArrayList<Integer>(Arrays.asList(2, 15)));
        listA.add(new ArrayList<Integer>(Arrays.asList(3, 9)));
        // listA.add(new ArrayList<Integer>(Arrays.asList(4, 10)));
        listB.add(new ArrayList<Integer>(Arrays.asList(1, 8)));
        listB.add(new ArrayList<Integer>(Arrays.asList(2, 11)));
        listB.add(new ArrayList<Integer>(Arrays.asList(3, 12)));
        // listB.add(new ArrayList<Integer>(Arrays.asList(4, 5)));
        System.out.println("a = " + listA);
        System.out.println("b = " + listB);
        int target = 20;
        System.out.println("target = " + target);
        System.out.println(closestSum(listA, listB, target));
    }
}
