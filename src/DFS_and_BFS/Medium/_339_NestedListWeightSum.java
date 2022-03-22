package DFS_and_BFS.Medium;

import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _339_NestedListWeightSum {

      // This is the interface that allows for creating nested lists.
      // You should not implement it, or speculate about its implementation
      public interface NestedInteger {
          // Constructor initializes an empty nested list.
         // public NestedInteger(){}

          // Constructor initializes a single integer.
         // public NestedInteger(int value){}

          // @return true if this NestedInteger holds a single integer, rather than a nested list.
          public boolean isInteger();

          // @return the single integer that this NestedInteger holds, if it holds a single integer
          // Return null if this NestedInteger holds a nested list
          public Integer getInteger();

          // Set this NestedInteger to hold a single integer.
          public void setInteger(int value);

          // Set this NestedInteger to hold a nested list and adds a nested integer to it.
          public void add(NestedInteger ni);

          // @return the nested list that this NestedInteger holds, if it holds a nested list
          // Return empty list if this NestedInteger holds a single integer
          public List<NestedInteger> getList();
      }




    int res;
    public int depthSum(List<NestedInteger> nestedList) {
        dfs(nestedList, 1);
        return res;
    }

    private void dfs(List<NestedInteger> nestedList, int depth){
        for(NestedInteger nest : nestedList){
            if(nest.isInteger()){
                res += nest.getInteger() * depth;
            }else{
                dfs(nest.getList(), depth+1);
            }
        }
    }
}
