package Tree.BST;

public class _109_ConvertSortedListToBinarySearch {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode start, ListNode end){
        if(start==null || start==end) { return null; }
        else if(start.next==end){
            TreeNode node = new TreeNode(start.val);
            return node;
        }
        ListNode fast = start;
        ListNode slow = start;
        while(fast!=end && fast.next!=end){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = buildTree(start, slow);
        root.right = buildTree(slow.next, end);
        return root;
    }

    /*
    ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        int size = getSize(head);
        this.head = head;
        return buildTree(0, size-1);
    }

    private TreeNode buildTree(int start, int end){
        if(start > end) return null;
        int mid = start + (end-start)/2;
        TreeNode leftSide = buildTree(start, mid-1);
        TreeNode root = new TreeNode(this.head.val);
        root.left = leftSide;
        this.head = this.head.next;
        root.right = buildTree(mid+1, end);
        return root;
    }
    private int getSize(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
     */
}
