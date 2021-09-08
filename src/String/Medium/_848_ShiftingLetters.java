package String.Medium;

/**
 * Created by Shuhua Song
 */
public class _848_ShiftingLetters {

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
    }
}
