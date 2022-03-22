package DFS_and_BFS.Medium;

import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _364_NestedListWeightSum_II {
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


    //Answer
    int res = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = getMaxDepth(nestedList);
        dfs(nestedList, 1, maxDepth);
        return res;
    }
    private void dfs(List<NestedInteger> nestedList, int depth, int maxDepth){
        for(NestedInteger nest : nestedList){
            if(nest.isInteger()) res += nest.getInteger() * (maxDepth-depth+1);
            else{
                dfs(nest.getList(), depth+1, maxDepth);
            }
        }
    }
    private int getMaxDepth(List<NestedInteger> nestedList){
        int depth = 1;
        for(NestedInteger nest : nestedList){
            if(!nest.isInteger()){
                depth = Math.max(depth, 1 + getMaxDepth(nest.getList()));
            }
        }
        return depth;
    }

    /*
     //BFS--Faster
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int res = 0, levelSum = 0;
        Queue<NestedInteger> q = new LinkedList<>();
        q.addAll(nestedList);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                NestedInteger ni = q.poll();
                if(ni.isInteger()) levelSum += ni.getInteger();
                else{
                    q.addAll(ni.getList());
                }
            }
            //LevelSum is an accumulative value
            res += levelSum;
        }
        return res;
    }
     */
}
