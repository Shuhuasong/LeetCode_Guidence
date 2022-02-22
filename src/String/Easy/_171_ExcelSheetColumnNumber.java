package String.Easy;

/**
 * Created by Shuhua Song
 */



public class _171_ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int exp = n-1;
        int res = 0;
        for(int i=0; i<n; i++){
            res += (columnTitle.charAt(i)-'A'+1)*(int)Math.pow(26, exp);
            exp -= 1;
        }
        return res;
    }
}

/*
A->1
B->2
C->3
...
Z->26
AA->27 (A-'A'+1)*26+(A-'A'+1)
AB->28
AC->29
...
AZ->52
BA->53

ZY->701   ('Z'-'A'+1) * 26 + ('Y'-'A') = 26*28 + 25
ZZ->702
AAA->703
*/
