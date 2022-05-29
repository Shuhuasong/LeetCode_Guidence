package String.Medium;

/**
 * Created by Shuhua Song
 */
public class _2288_ApplyDiscountToPrice {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<words.length; i++){
            String w = words[i];
            if(isValid(w)){
                double val = Double.parseDouble(w.substring(1));
                if(discount==100){
                    val = 0.00;
                }else{
                    val = val * ((100-discount)*1.0/100);
                }
                words[i] = "$" + String.format("%.2f", val);
            }
            sb.append(words[i]).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private boolean isValid(String w){
        if(w.length() < 2) return false;
        return w.startsWith("$") && w.substring(1).matches("\\d+");
    }
}


/*

"there are $1 $2 and 5$ candies in the shop"
50
"1 2 $3 4 $5 $6 7 8$ $9 $10$"
100
"ka3caz4837h6ada4 r1 $602"
9
*/
