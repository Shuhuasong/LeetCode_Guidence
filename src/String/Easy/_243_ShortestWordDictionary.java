package String.Easy;

/**
 * Created by Shuhua Song
 */
public class _243_ShortestWordDictionary {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int l1 = -1, l2 = -1;
        int res = wordsDict.length;
        for(int i=0; i<wordsDict.length; i++){
            if(wordsDict[i].equals(word1)){
                l1 = i;
            }
            if(wordsDict[i].equals(word2)){
                l2 = i;
            }

            if(l1 != -1 && l2 != -1){
                res = Math.min(res, Math.abs(l1-l2));
            }
        }
        return res;
    }
}
