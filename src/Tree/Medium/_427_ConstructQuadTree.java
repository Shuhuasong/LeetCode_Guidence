package Tree.Medium;

/**
 * Created by Shuhua Song
 */
public class _427_ConstructQuadTree {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
    }

    public Node construct(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        return buildTree(grid, 0, rows-1, 0, cols-1);
    }

    private Node buildTree(int[][] grid, int left, int right, int up, int down){
        Node root = new Node();
        if(isSame(grid, left, right, up, down)){
            root.isLeaf = true;
            root.val = grid[up][left]==1;
            return root;
        }
        root.isLeaf = false;
        root.topLeft = buildTree(grid, left, (left+right)/2, up, (up+down)/2);
        root.topRight = buildTree(grid, (left+right)/2+1, right, up, (up+down)/2);
        root.bottomLeft = buildTree(grid, left, (left+right)/2, (up+down)/2+1, down);
        root.bottomRight = buildTree(grid, (left+right)/2+1, right, (up+down)/2+1, down);
        return root;
    }

    private boolean isSame(int[][] grid, int left, int right, int up, int down){
        int val = -1;
        for(int i=up; i<=down; i++){
            for(int j=left; j<=right; j++){
                if(val==-1){
                    val = grid[i][j];
                }else if(val != grid[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
