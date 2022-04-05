package Tree.BST;

import java.util.ArrayList;
import java.util.List;

public class _109_ConvertSortedListToBinarySearch {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    //Recursion + Convert to Array
    //Time = O(n), Space = O(n)
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        return buildTree(list, 0, list.size()-1);
    }

    private TreeNode buildTree(List<Integer> list, int start, int end){
        if(start>end) return null;
        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildTree(list, start, mid-1);
        root.right = buildTree(list, mid+1, end);
        return root;
    }

    /*
     //Recursion + Convert to Array
    //Time = O(n*logn), Space = O(logn) recursion stack
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        ListNode mid = findMiddle(head);
        TreeNode root = new TreeNode(mid.val);
        if(head==mid) return root;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev!=null) prev.next = null;
        return slow;
    }
     */




/*
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
    } */

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

/*
Solution-Recursion:
1) find the middle node in the list
2) use the mid node to creat root node;
   seperate the list into two sub-list
3) recursive build tree for these two sub-list
       set root.left = sortListBST(head);
       root.right =sortListBST(mid.next);

 */
