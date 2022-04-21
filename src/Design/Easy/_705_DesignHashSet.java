package Design.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _705_DesignHashSet {

    final private int size;
    private List<Integer>[] buckes;
    public _705_DesignHashSet() {
        size = 1009;//prime number for almost even distribution across
        buckes = new ArrayList[size];
        for(int i=0; i<size; i++){
            buckes[i] = new ArrayList<>();
        }
    }

    private int hashCode(int key){
        return key%size;
    }

    public void add(int key) {
        if(contains(key)) return;
        int buckIdx = hashCode(key);
        List<Integer> buck = buckes[buckIdx];
        buck.add(key);
    }

    public void remove(int key) {
        if(!contains(key)) return;
        int buckIdx = hashCode(key);
        List<Integer> buck = buckes[buckIdx];
        for(int i=0; i<buck.size(); i++){
            if(buck.get(i)==key){
                buck.remove(i);
                break;
            }
        }
    }

    public boolean contains(int key) {
        int buckIdx = hashCode(key);
        List<Integer> buck = buckes[buckIdx];
        return buck.contains(key);
    }

    /*
     int[] nums;
    public MyHashSet() {
        nums = new int[1000001];
        Arrays.fill(nums, Integer.MIN_VALUE);
    }

    public void add(int key) {
        nums[key] = 1;
    }

    public void remove(int key) {
        nums[key] = Integer.MIN_VALUE;
    }

    public boolean contains(int key) {
        return nums[key]!=Integer.MIN_VALUE;
    }
     */
}
