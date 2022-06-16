package String.Easy;

/**
 * Created by Shuhua Song
 */
public class _245_ShortestWordDistance_III {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;
        int res = n, idx1 = -1, idx2 = -1;
        for(int i=0; i<n; i++){
            if(wordsDict[i].equals(word1)){
                idx1 = i;
                if(idx2!=-1){
                    res = Math.min(res, idx1-idx2);
                }
            }
            if(wordsDict[i].equals(word2)){
                idx2 = i;
                if(idx1 != -1 && idx1 != idx2){
                    res = Math.min(res, Math.abs(idx1-idx2));
                }
            }
        }
        return res;
    }
}

//["practice", "makes", "perfect", "coding", "makes"]
/*

["practice", "makes", "perfect", "coding", "makes"]

"makes"
"coding"

      0         1         2         3         4
["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "makes"
                 |
idx1 = 1,       res = 3
idx2 = -1



["a","b"]
"a"
"b"

*/
