package OnlineCodingChallege.BlackRock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Shuhua Song
 */
public class _CoinChange_ {

    enum Coin {
        Fifty_Pound(50, "Fifty Pounds"), Twenty_Pounds(20, "Twenty Pounds"),
        Ten_Pounds(10, "Ten Pounds"), Five_Pounds(5, "Five Pounds"),
        Two_Pounds(2, "Two_Pounds"), One_Pounds(2, "One Pound"),
        Fifty_Pence(50, "Fifty Pence"), Twenty_Pence(20, "Twenty Pence"),
        Ten_Pence(10, "Ten Pence"), Five_Pence(5, "Five Pence"),
        Two_Pence(2, "Two Pence"), One_Pence(1, "One Pence");
        private double value;
        private String code;

        Coin(double value, String code) {
            this.value = value;
            this.code = code;
        }

        public double getValue() {
            return value;
        }

        public String getCode() {
            return code;
        }
    }

    static void getChanges(double purchase, double cashes) {
        if(purchase==cashes){
            System.out.println("ZERO");
            return;
        }
        if( purchase < 0 || cashes < 0 || cashes < purchase ){
            System.out.println("ERROR");
            return;
        }
        double change = cashes-purchase;
        StringBuilder sb = new StringBuilder();
        Coin[] coins = Coin.values();
        for(Coin coin : coins){
            int amount = (int)(change/coin.getValue());
            if(amount != 0){
                for(int i=0; i<amount; i++){
                    sb.append(coin.getCode()).append(", ");
                }
            }
            change = change - amount * coin.getValue();
            change = (double)(Math.round(change*100))/100;
            if(change==0){
                break;
            }
        }
        String result = sb.toString();
        if(result != "" || result != ", "){
            result = result.substring(0, result.length()-2);
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
         InputStream is = null;
         BufferedReader br = null;

         is = System.in;
         br = new BufferedReader(new InputStreamReader(is));
         String line = null;
         try{
             while((line = br.readLine()) != null){
                // if(line.equalsIgnoreCase("quit")){
                 //    break;
                // }
                 line = line.trim();
                 String[] paras = line.split(";");
                 double purchase = Double.parseDouble(paras[0]);
                 double cashes = Double.parseDouble(paras[1]);
                 _CoinChange_.getChanges(purchase, cashes);
             }
         }
         catch(IOException e){
             throw new IOException("Error when reading a line", e);
         }

    }
}
