package DFS_and_BFS.Medium;

import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _364_NestedListWeightSumII {
    public class NestedInteger{

              // Constructor initializes an empty nested list.
              public NestedInteger(){ }

              // Constructor initializes a single integer.
              public NestedInteger(int value){}

              // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger(){ return true; }

              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger(){ return 0;}

             // Set this NestedInteger to hold a single integer.
              public void setInteger(int value){}

              // Set this NestedInteger to hold a nested list and adds a nested integer to it.
              public void add(NestedInteger ni){}

              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return empty list if this NestedInteger holds a single integer
              public List<NestedInteger> getList(){ return null; }

    }

    int res = 0, maxDepth = -1;
    public int depthSumInverse(List<NestedInteger> nestedList){
        findMaxDepth(nestedList, 1);
        parse(nestedList, 1);
        return res;
    }

    private void findMaxDepth(List<NestedInteger> nestedList, int level){
        maxDepth = Math.max(maxDepth, level);
        for(NestedInteger ni : nestedList){
            if(!ni.isInteger()){
                findMaxDepth(ni.getList(), level+1);
            }
        }
    }

    private void parse(List<NestedInteger> nestedList, int level){
        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                res += ni.getInteger() * (maxDepth-level+1);
            }else{
                parse(ni.getList(), level+1);
            }
        }
    }
}
