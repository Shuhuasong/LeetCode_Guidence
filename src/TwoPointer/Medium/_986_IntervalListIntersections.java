package TwoPointer.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _986_IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> results = new ArrayList<>();
        int i = 0, j = 0;
        int m = firstList.length, n = secondList.length;
        while(i < m && j < n){
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            if(lo <= hi){
                results.add(new int[]{lo, hi});
            }
            if(firstList[i][1] < secondList[j][1]){
                i++;
            }else{
                j++;
            }
        }
        return results.toArray(new int[results.size()][]);
    }
}

/*
Solution-two pointer:
1) if A[0] has the smallest endpoint, it can only intersect B[0].
   After, we can discard A[0] since it cannot intersect anything else
2) if B[0] has the smallest endpoint, it can only intersect A[0], and we
    we discard B[0] after since it cannot intersect anything else


   [[0,2],[5,10],[13,23],[24,25]]
                           |

   [[1,5],[8,12],[15,24],[25,26]]
                            |

   {1, 2},{5,5}, {8,10},{15,23},{24,24},{25,25}

*/
