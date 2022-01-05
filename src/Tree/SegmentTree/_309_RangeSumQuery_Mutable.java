package Tree.SegmentTree;

/**
 * Created by Shuhua Song
 */
public class _309_RangeSumQuery_Mutable {
    SegmentTreeNode root;

    public _309_RangeSumQuery_Mutable(int[] nums) {
        this.root = buildTree(nums, 0, nums.length-1);

    }

    public void update(int index, int val) {
        newUpdate(root, index, val);
    }

    public int sumRange(int left, int right) {
        return newSumRange(root, left, right);
    }

    public int newSumRange(SegmentTreeNode root, int start, int end){
        if(root.start==start && root.end==end) return root.val;
        int mid = root.start + (root.end-root.start)/2;
        if(end <= mid){
            return newSumRange(root.left, start, end);
        }else if(start >= mid + 1){
            return newSumRange(root.right, start, end);
        }else{
            return newSumRange(root.left, start, mid) +
                    newSumRange(root.right, mid+1, end);
        }
    }

    public void newUpdate(SegmentTreeNode root, int index, int newVal){
        if(root.start==root.end){
            root.val = newVal;
            return;
        }
        int mid = root.start + (root.end-root.start)/2;
        if(index <= mid){
            newUpdate(root.left, index, newVal);
        }else{
            newUpdate(root.right, index, newVal);
        }
        //update the parent's value
        root.val = root.left.val + root.right.val;
    }

    public SegmentTreeNode buildTree(int[] nums, int start, int end){
        if(start > end) return null;
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if(start==end){
            node.val = nums[start];
        }else{
            int mid = start + (end-start)/2;
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid+1, end);
            node.val = node.left.val + node.right.val;
        }
        return node;
    }

    class SegmentTreeNode{
        int start, end;
        int val;
        SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            val = 0;
        }
    }
}
