package DFS_and_BFS.Medium;

/**
 * Created by Shuhua Song
 */
public class _1138_AlphabetBoardPath {
    //Don't need to build a Character board, we only need to calculate the indice directly
    //By comparing the current indices and the previous ones, the path then could be found
    //Note: the moving down and moving right, may move into a cell doesn't exist
    //To avoid this, we put 'L', 'U' before 'R', 'D'
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int preR = 0, preC = 0;
        for(char c : target.toCharArray()){
            int  curR = (c-'a')/5; // get row number
            int curC = (c-'a')%5;
            path(sb, preR, preC, curR, curC);
            sb.append("!");
            preR = curR;
            preC = curC;
        }
        return sb.toString();
    }

    private void path(StringBuilder sb, int preR, int preC, int curR, int curC){
        while(preC > curC){
            preC--;
            sb.append("L");
        }
        while(preR > curR){
            preR--;
            sb.append("U");
        }
        while(preC < curC){
            preC++;
            sb.append("R");
        }
        while(preR < curR){
            preR++;
            sb.append("D");
        }
    }
}

/*
 target = "leet"
"DDR!UURRR!!DDD!"

preR = 0 D 1 D 2
preC = 0 R 1
curR = 2
curC = 1

*/
