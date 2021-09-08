package Golden_Sach_21FallOA;

/**
 * Created by Shuhua Song
 */
/*
越狱问题，[hide=188] 给定一个监狱有多少个水平栏杆和竖直栏杆，再给定一个array 是要被去掉的水平的栏杆，和要被去掉的竖直栏杆，然后找出最大的洞。
 */
public class BreakPrison {

    private static int largestArea(int m, int n, int[] hor, int[] ver){
        boolean[] xArr = new boolean[m+1];
        boolean[] yArr = new boolean[n+1];
        for(int h : hor) xArr[h] = true;
        for(int v : ver) yArr[v] = true;

        int len1 = 0, len2 = 0;
        for(int i=1, j=0; i<=m; i++){
            if(!xArr[i]){
                j = 0;
            }else{
                len1 = Math.max(len1, ++j);
            }
        }
        for(int i=1,j=0; i<=n; i++){
            if(!yArr[i]){
                j = 0;
            }else{
                len2 = Math.max(len2, ++j);
            }
        }
        System.out.println(len1 + " " + len2);
        return (len1+1)*(len2+1);
    }

    public static void main(String[] args) {
        int m = 6, n = 6;
        int[] hor = {4,5};
        int[] ver = {2,3};
        System.out.println(largestArea(6, 6, hor, ver));
    }
}
