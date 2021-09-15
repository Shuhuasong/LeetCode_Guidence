package OnlineCodingChallege.BlackRock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Shuhua Song
 */
public class _StockAndBond {

    static class Asset implements Comparable<Asset> {
        String name, type;
        int share;

        public Asset(String name, String type, int share) {
            this.name = name;
            this.type = type;
            this.share = share;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public int getShare() {
            return share;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setShare(int share) {
            this.share = share;
        }

        @Override
        public int compareTo(Asset other) {
            return this.getName().compareTo(other.getName());
        }

        @Override
        public String toString() {
            return "name: " + name + " tye: " + type + " share: " + share;
        }
    }

    static ArrayList<Asset> portfolioBond = new ArrayList<>();
    static ArrayList<Asset> portfolioStock = new ArrayList<>();
    static ArrayList<Asset> benchStock = new ArrayList<>();
    static ArrayList<Asset> benchBond = new ArrayList<>();
    static ArrayList<String> sellResult = new ArrayList<String>();
    static ArrayList<String> buyResult = new ArrayList<String>();

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
                _StockAndBond.checkEqual(line);
                clearList();
            }
        }
        catch(IOException e){
            throw new IOException("Error when reading a line", e);
        }
    }

    private static void checkEqual(String line) {
        SeperateStockAndBond(line);
        Collections.sort(portfolioBond);
        Collections.sort(portfolioStock);
        Collections.sort(benchBond);
        Collections.sort(benchStock);
        shareCompare(portfolioBond, benchBond);
        shareCompare(portfolioStock, benchStock);
    }

    private static void shareCompare(ArrayList<Asset> port, ArrayList<Asset> bench) {
         int portIdx = 0, benchIdx = 0;
         while(portIdx < port.size() || benchIdx < bench.size()){
             if(portIdx >= port.size()){
                 for(int i=benchIdx; i<bench.size(); i++){
                     Asset as = bench.get(i);
                     buyResult.add("BUY," + as.getName() + "," + as.getType() + "," + as.getShare());
                 }
                 break;
             }
             if(benchIdx >= bench.size()){
                 for(int i=portIdx; i<port.size(); i++){
                     Asset as = port.get(i);
                     sellResult.add("SELL," + as.getName() + "," + as.getType() + "," + as.getShare());
                 }
                 break;
             }
             Asset portAsset = port.get(portIdx);
             Asset benchAsset = bench.get(benchIdx);
             // compare the number of share of assets in both portfolio and benchmark
             if(portAsset.getName().compareTo(benchAsset.getName())==0){
                 if(portAsset.getShare() < benchAsset.getShare()){
                     buyResult.add("BUY," + portAsset.getName() + "," + portAsset.getType() + "," +
                             (portAsset.getShare()-benchAsset.getShare()));
                 }else if(portAsset.getShare() > benchAsset.getShare()){
                     sellResult.add("SELL," + portAsset.getName() + "," + portAsset.getType() + "," +
                             (benchAsset.getShare()-portAsset.getShare()));
                 }
                 portIdx++;
                 benchIdx++;
             }
             // this asset is in portfolio, but not in benchmark
             else if(portAsset.getName().compareTo(benchAsset.getName()) < 0){
                 sellResult.add("SELL," + portAsset.getName() + "," + portAsset.getType() + "," +
                         portAsset.getShare());
             }
             // the asset in benchmark is not in portfolio
             else if(portAsset.getName().compareTo(benchAsset.getName()) > 0){
                 buyResult.add("BUY," + portAsset.getName() + "," + portAsset.getType() + "," +
                         benchAsset.getShare());
             }
         }
    }

    private static void clearList() {
         portfolioBond = new ArrayList<>();
         portfolioStock = new ArrayList<>();
         benchStock = new ArrayList<>();
         benchBond = new ArrayList<>();
         sellResult = new ArrayList<String>();
         buyResult = new ArrayList<String>();
    }

    private static void SeperateStockAndBond(String line) {
        String[] portAndBench = line.split(":");
        String[] portfolio;
        String[] bench;
        if (!line.contains(":")) { // invalid input
            return;

        }
        // normal case where both portfolio and benchmark have assets
        else if (portAndBench.length == 2 && line.substring(0, line.indexOf(":")).contains(",")) {
            portfolio = portAndBench[0].split("\\|");
            bench = portAndBench[1].split("\\|");
        } else if (line.substring(0, line.indexOf(":")).contains(",")) { // no assets in benchmark
            portfolio = portAndBench[0].split("\\|");
            bench = new String[0];
        } else { // no assets in portfolio
            portfolio = new String[0];
            bench = portAndBench[1].split("\\|");
        }

        checkAsset(portfolio, portfolioBond, portfolioStock);
        checkAsset(bench, benchBond, benchStock);
    }

    public static void checkAsset(String[] source, ArrayList<Asset> bond, ArrayList<Asset> stock) {
        for (String s : source) {
            String[] tmp = s.split(",");
            int share = Integer.parseInt(tmp[2].trim());
            Asset asset = new Asset(tmp[0].trim(), tmp[1].trim(), share);
            if (isBond(tmp[1])) {
                bond.add(asset);
            } else if (isStock(tmp[1])) {
                stock.add(asset);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * check if this asset is a stock
     *
     * @param input
     * @return
     */
    public static boolean isStock(String input) {
        if (input.toLowerCase().contains("stock"))
            return true;
        return false;
    }

    /**
     * check if this asset is a bond
     *
     * @param input
     * @return
     */
    public static boolean isBond(String input) {
        if (input.toLowerCase().contains("bond"))
            return true;
        return false;
    }
}
