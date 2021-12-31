package BinarySearch.Medium;

/**
 * Created by Shuhua Song
 */
public class _1618_MaximumFontToFitASentenceInAScreen {

    interface FontInfo {
      // Return the width of char ch when fontSize is used.
             public int getWidth(int fontSize, char ch);

        // Return Height of any char when fontSize is used.
        int getHeight(int fontSize);
  }

    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int n = fonts.length;
        int left = 0, right = n-1;
        int res = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            int fontSize = fonts[mid];
            if(goodSize(text, w, h, fontSize, fontInfo)){
                res = fonts[mid];
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }

    private boolean goodSize(String text, int w, int h, int font, FontInfo fontInfo){
        int currH = fontInfo.getHeight(font);
        if(currH > h) return false;
        int total = 0;
        for(int i=0; i<text.length(); i++){
            total += fontInfo.getWidth(font, text.charAt(i));
            if(total > w) return false;
        }
        return true;
    }
}
