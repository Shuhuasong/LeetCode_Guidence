package OnlineCodingChallege.BlackRock;

/**
 * Created by Shuhua Song
 */

/*
Currency Exchange
Programming challenge description:
Given

A list of foreign exchange rates
A selected curreny
A target currency
Your goal is to calculate the max amount of the target currency to 1 unit of the selected currency through the FX transactions. Assume all transations are free and done immediately. If you cannot finish the exchange, return -1.0.

Input:
You will be provided a list of fx rates, a selected currency, and a target currency.

For example:

FX rates list:
  USD to JPY 1 to 109
  USD to GBP 1 to 0.71
  GBP to JPY 1 to 155
Original currency: USD
Target currency : JPY
Output:
Calculated the max target currency will can get.

For example:

USD to JPY -> 109
USD to GBP to JPY = 0.71 * 155 = 110.05 > 109,
so the max value will be 110.05

Test 1
Test Input
Download Test 1 Input
USD,GBP,0.7;USD,JPY,109;GBP,JPY,155;CAD,CNY,5.27;CAD,KRW,921
USD
CNY
Expected Output
Download Test 1 Input
-1.0
Test 2
Test Input
Download Test 2 Input
USD,CAD,1.3;USD,GBP,0.71;USD,JPY,109;GBP,JPY,155
USD
JPY
Expected Output
Download Test 2 Input
110.05
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.HashMap;
/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */

class _CurrencyExchage_ {
    /**
     * Iterate through each line of input.
     */

    private static double calculateRate(String lineA, String lineB, String lineC){
        String[] converts = lineA.split(";");
        String currCash = lineB;
        String targetCash = lineC;
        HashMap<String, Integer> currencyToIndex = new HashMap<>();
        //ArrayList<Node> rateNodes = new ArrayList<Node>();
        int nodeNum = 0;
        for(String convert : converts){
            String[] nodes = convert.split(",");
            String src = nodes[0].trim();
            String dest = nodes[1].trim();
            if(!currencyToIndex.containsKey(src)){
                currencyToIndex.put(src, nodeNum);
                nodeNum++;
            }
            if(!currencyToIndex.containsKey(dest)){
                currencyToIndex.put(dest, nodeNum);
                nodeNum++;
            }
        }
        int n = currencyToIndex.size();
        int[][] edges = new int[n][2];
        double[] rates = new double[n];
        int k = 0;
        for(String convert : converts){
            //System.out.println(convert);
            String[] nodes = convert.split(",");
            String src = nodes[0].trim();
            String dest = nodes[1].trim();
            int start = currencyToIndex.get(src);
            int end = currencyToIndex.get(dest);
            edges[k] = new int[]{start, end};
            rates[k] = Double.parseDouble(nodes[2].trim());
            k++;
        }
        int currNode = currencyToIndex.get(currCash);
        int targetNode = currencyToIndex.get(targetCash);
        double result = getMaxRate(n, edges, rates, currNode, targetNode);
        return result;
    }

    private static double getMaxRate(int n, int[][] edges, double[] rates, int start, int end){
        double res = -1.0;
        HashMap<Integer, Double>[] graph = new HashMap[n];
        for(int i=0; i<n; i++){
            graph[i] = new HashMap<>();
        }
        ArrayList<Double> ans = new ArrayList<>();
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double rate = rates[i];
            graph[u].put(v, rate);
            graph[v].put(u, 1.0/rate);
        }
        boolean[] visited = new boolean[n];
        //PriorityQueue<double[]> q = new PriorityQueue<>((a, b)->Double.compare(b[1], a[1]));
        Queue<double[]> q = new LinkedList<>();
        q.offer(new double[]{start, 1});
        while(!q.isEmpty()){
            double[] currP = q.poll();
            int currNode = (int)currP[0];
            double currRate = currP[1];
            //System.out.println( "currRate = " + currRate);//
            if(currNode==end){
                ans.add(currRate);
            }
            if(visited[currNode]) continue;
            visited[currNode] = true;
            for(Map.Entry<Integer, Double> entry: graph[currNode].entrySet()){
                if(!visited[entry.getKey()]){
                    //System.out.println(entry.getValue() + " " + currRate);
                    q.offer(new double[]{entry.getKey(), entry.getValue() * currRate});
                }
            }
        }
        for(double r : ans){
            // System.out.println("res = " + r); //
            res = Math.max(r, res);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line, lineA = null, lineB = null, lineC = null;
        while ((line = in.readLine()) != null) {
            //System.out.println(line);
            line = line.trim();
            if(lineA==null){
                lineA = line;
            }else if(lineB==null){
                lineB = line;
            }else if(lineC==null){
                lineC = line;
            }
            //lineA = null; lineB = null; lineC = null;
        }
        //System.out.println(lineA);
        //System.out.println(lineB);
        //System.out.println(lineC);
        double result =  _CurrencyExchage_.calculateRate(lineA, lineB, lineC);
        System.out.println(result);
    }
}
