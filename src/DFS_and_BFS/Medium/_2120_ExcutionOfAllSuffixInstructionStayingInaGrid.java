package DFS_and_BFS.Medium;

/**
 * Created by Shuhua Song
 */
public class _2120_ExcutionOfAllSuffixInstructionStayingInaGrid {
    //Time = O(m^2)
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int l = s.length();
        int[] res = new int[l];
        int count = 0;
        for(int i=0; i<l; i++){
            int r = startPos[0], c = startPos[1];
            count = 0;
            for(int j=i; j<l; j++){
                char ch = s.charAt(j);
                if(ch=='U') r = r-1;
                else if(ch=='R') c = c+1;
                else if(ch=='L') c = c-1;
                else if(ch=='D') r = r+1;

                if(r < 0 || r>=n || c<0 || c>=n ){
                    res[i] = count;
                    break;
                }else{
                    count++;
                }

                if(j==l-1){
                    res[i] = count;
                }
            }
        }
        return res;
    }
   /*
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int l = s.length();
        int[] res = new int[l];
        int count = 0;
        for(int i=0; i<l; i++){
            String sub = s.substring(i);
            count = dfs(n, 0, startPos[0], startPos[1], sub.toCharArray());
            res[i] = count;
        }
        return res;
    }

    private int dfs(int n, int idx, int r, int c, char[] dirs){
        if(idx==dirs.length) return 0;
        else if(dirs[idx]=='R' && (c+1) < n){
            return 1+dfs(n, idx+1, r, c+1, dirs);
        }
        else if(dirs[idx]=='L' && (c-1) >= 0){
            return 1+dfs(n, idx+1, r, c-1, dirs);
        }
        else if(dirs[idx]=='U' && (r-1) >= 0){
            return 1+dfs(n, idx+1, r-1, c, dirs);
        }
        else if(dirs[idx]=='D' && (r+1) < n){
            return 1+dfs(n, idx+1, r+1, c, dirs);
        }
        return 0;
    } */
}
