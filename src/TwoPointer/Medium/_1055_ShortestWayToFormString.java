package TwoPointer.Medium;

/**
 * Created by Shuhua Song
 */
public class _1055_ShortestWayToFormString {
   //Time = O(m*n)
    public int shortestWay(String source, String target) {
        int m = source.length(), n = target.length();
        int t = 0, res = 0;
        while(t < n){
            int tmp = t;
            for(int i=0; i<m; i++){
                if(t < n && target.charAt(t)==source.charAt(i)){
                    t++;
                }
            }
            if(tmp==t) return -1;
            res++;
        }
        return res;
    }

    /*
      //Time = O(m+nlogn)
    public int shortestWay(String source, String target) {
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        for(int i=0; i<source.length(); i++){
            char c = source.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, new TreeSet<>());
            }
            map.get(c).add(i);
        }
        int res = 0, prevIdx = -1;
        for(int i=0; i<target.length(); i++){
            char c = target.charAt(i);

            if(!map.containsKey(c)) return -1;
            TreeSet<Integer> set = map.get(c);

            Integer currIdx = set.ceiling(prevIdx+1);
            //the index can't find in the set, reset the prevIdx,start a new subSequce
            if(currIdx==null){
                res++;
                i--; //!! need to move back one step
                prevIdx = -1;
            }else{
                prevIdx = currIdx;
            }
        }
        if(prevIdx != -1) res++;
        return res;
    }
     */
}
