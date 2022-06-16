package String.Easy;

/**
 * Created by Shuhua Song
 */
public class _243_ShortestWordDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;
        int idx1 = -1, idx2 = -1;
        int res = n;
        for(int i=0; i<wordsDict.length; i++){
            if(wordsDict[i].equals(word1)){
                idx1 = i;
                if(idx2!=-1){
                    res = Math.min(res, idx1-idx2);
                }
            }else if(wordsDict[i].equals(word2)){
                idx2 = i;
                if(idx1!=-1){
                    res = Math.min(res, idx2-idx1);
                }
            }
        }
        return res;
    }
}

/*
         0 1 2 3 4 5 6 7 8
input = {A B C D A C A D E}, short distance(A, D)


Solution-1: Brute force
Time = O(n^2)
1) Collection all the position index for word1 and word2 in a seperate list
e.g
list1 = A : {0, 4, 6} n/2
list2 = D : {3, 7}  n/2

Solution-2: Optimize
1. binary Search for each list1.get(i) in list2.get(j)
   such that  |list1.get(i) - list2.get(j)| is min
   Time : O(m*logn) ==> m = smaller list, n = larger list

2. Two pointer: update the res, move forword the pointer with smaller index
    list1 = A : {0, 4, 6}
                 |
    list2 = D : {3, 7}
                 |

3. Linear scan, keep two latest variable index for two words
              0 1 2 3 4 5 6 7 8
     input = {A B C D A C A D E}
index1=-1     0       4   6 7
index2=-1           3
    res             3 1
    */
