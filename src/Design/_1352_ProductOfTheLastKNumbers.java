package Design;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _1352_ProductOfTheLastKNumbers {
    List<Integer> list = new ArrayList<>();
    public _1352_ProductOfTheLastKNumbers(){ }

    public void add(int num){
        if(num==0){
            list.clear();
            return;
        }
        int prev = (list.size() > 0) ? list.get(list.size()-1) : 1;
        list.add(num * prev);
    }

    public int getProduct(int k){
        int n = list.size();
        if(k > n) return 0;
        int last = list.get(list.size()-1);
        if(n+1==k) return last;
        int val = list.get(n-k);
        return last/val;
    }
}
