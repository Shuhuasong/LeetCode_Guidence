package TwoPointer.Medium;

/**
 * Created by Shuhua Song
 */
public class _165_CompareVersionNumbers {
    //Time = O(max(m, n)), Space = O(max(m,n))
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int n1 = str1.length, n2 = str2.length;
        for(int i=0,j=0;i<n1 || j<n2 ; i++,j++){
            int v1 = i<n1 ? Integer.parseInt(str1[i]) : 0;
            int v2 = j<n2 ? Integer.parseInt(str2[i]) : 0;
            if(v1 != v2) return v1 > v2 ? 1 : -1;
        }
        return 0;
    }

    /*
     public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int n1 = str1.length, n2 = str2.length;
        int[] num1 = new int[n1],num2 = new int[n2];
        for(int i=0; i<n1; i++){ num1[i] = Integer.parseInt(str1[i]); }
        for(int i=0; i<n2; i++){ num2[i] = Integer.parseInt(str2[i]); }
        int i;
        for(i=0; i<Math.min(n1, n2); i++){
            if(num1[i] < num2[i]) return -1;
            else if(num1[i] > num2[i]) return 1;
        }
        int j=i;
        while(j<n1){
            if(num1[j]!=0) return 1;
            j++;
        }
        while(j<n2){
            if(num2[j]!=0) return -1;
            j++;
        }
        return 0;
}
     */
}
