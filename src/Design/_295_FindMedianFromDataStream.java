package Design;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _295_FindMedianFromDataStream {

    Queue<Integer> smallerQ, largerQ;
    public _295_FindMedianFromDataStream() {
        smallerQ = new PriorityQueue<>((a, b) -> b-a);
        largerQ = new PriorityQueue<>();
    }

    public void addNum(int num) {
        smallerQ.add(num);
        //balancing two queue
        largerQ.add(smallerQ.poll());
        if(smallerQ.size() <  largerQ.size()){
            smallerQ.add(largerQ.poll());
        }
    }

    public double findMedian() {
        if(smallerQ.size() > largerQ.size()){
            return smallerQ.peek();
        }else{
            return (double)(smallerQ.peek()+largerQ.peek()) * 0.5;
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
}

/*
smallerQ : a max-heap to store the smaller half of the input numbers;
           hold (n+1) elements
largerQ : a min-heap to store the larger half of the input numbers;
           hold n elements
AddNum() :
-- Add num to map-heap lowerQ. Since lowerQ received a new element, we must do a balancing step for largerQ. So we remove the largest element from smallerQ and add it to largerQ
-- The min-heap laregerQ might hold more elements than the max-heap SmallerQ, after the previous operation, we fix the that by removing the smallest element from largetQ and add it to smallerQ
*/

