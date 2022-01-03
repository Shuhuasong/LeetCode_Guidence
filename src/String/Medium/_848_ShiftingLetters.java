package String.Medium;

/**
 * Created by Shuhua Song
 */
public class _848_ShiftingLetters {

    public String shiftingLetters(String s, int[] shifts) {
        int n= shifts.length;
        StringBuilder sb = new StringBuilder(s);
        for(int i=n-2; i>=0; i--){
            shifts[i] = (shifts[i] + shifts[i+1])%26;
        }
        for(int i=0; i<n; i++){
            sb.setCharAt(i, (char)((s.charAt(i)-'a'+shifts[i])%26+'a'));
        }
        return sb.toString();
    }
    /*
    public String shiftingLetters(String s, int[] shifts) {
        if(s.length()==0) return "";
        int n = shifts.length;
        int move = 0;
        for(int shift : shifts) {
            move = (move+shift)%26;
        }
        System.out.println(move);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i) - 'a';
            char newChar = (char)((index+move)%26 + 97);
            sb.append(newChar);
            move = Math.floorMod(move-shifts[i], 26);
            System.out.println(move);
        }
        return sb.toString();
    } */
}
