package OnlineCodingChallege.BlackRock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Created by Shuhua Song
 */
/*
ESG Issuer Graph
Programming challenge description:
ESG Issuer Data is of the form

Issuer | Parent | ESG Rating
-------------------------
A54365 | B34454 | AA
B34454 | C34563 | A
D45747 | B34454 | B
E36547 | D45747 | AAA
G34657 | D45747 | CCC
H84464 | C34563 | BB
I76474 | H84464 | AA
C34563 |        | BBB
F34654 |        | BB
J74576 | K46565 | C
K46565 |        | CC
L54334 | I76474 | AA
H84464 | L54334 | BB
Assumptions that can be made:

If asked to find a min or max rating, given an issuer, consider all the issuers in the path from the given issuer to the ultimate parent
Rating order AAA > AA > A > BBB > BB > B > CCC > CC > C
Your assignment:

Come up with a Data Structure to hold this type of data.
Write an algorithm to check if the relations above are cyclic in nature.
(Convert the Data Structure to a directed one assuming the direction is from the Issuer to its parent) Find the issuer with max rating
Input:
The issuer table, with respective columns:

Issuer Parent ESGRating, separated by |

Output:
If relations from the input table are cyclic in nature (cyclic or noncyclic)
issuer with max rating, return None if invalid/not applicable
max rating, return None if invalid/not applicable
Test 1
Test Input
Download Test 1 Input
A54365|B34454|CCC
B34454|C34563|A
D45747|B34454|B
E36547|D45747|AAA
G34657|D45747|CCC
H84464|C34563|BB
I76474|H84464|AA
C34563|      |BBB
F34654|      |BB
J74576|K46565|C
K46565|      |CC
L54334|I76474|AA
H84464|      |BB
Expected Output
Download Test 1 Input
noncyclic
C34563
BBB
Test 2
Test Input
Download Test 2 Input
A54365|B34454|AA
B34454|C34563|A
D45747|B34454|B
E36547|D45747|AAA
G34657|D45747|CCC
H84464|C34563|BB
I76474|H84464|AA
C34563||BBB
F34654||BB
J74576|K46565|C
K46565||CC
L54334|I76474|AA
H84464|L54334|BB
Expected Output
Download Test 2 Input
cyclic
A54365
AA
 */
public class _ESG_IssuerGraph_ {
    /**
     * Iterate through each line of input.
     */

    //Couldn't understand the Question
    //The question explaination is so confused for me, I nearly couldn't understand how the max rating in the  is
    //example is coming out
    private static void checkCycle_getMaxRating(ArrayList<String> inputLines){
        HashMap<String, Integer> idToIndex = new HashMap<>();
        int nodeNum = 0;
        for(String line : inputLines){
            line = line.trim();
            String[] nodes = line.split("|");
            String src = nodes[0].trim();
            String dest = nodes[1].trim();
            if(!idToIndex.containsKey(src)){
                idToIndex.put(src, nodeNum);
                nodeNum++;
            }
            if(!idToIndex.containsKey(dest)){
                idToIndex.put(dest, nodeNum);
                nodeNum++;
            }
        }
        int n = idToIndex.size();
        int[][] edges = new int[n][2];
        String[] rates = new String[n];
        int k = 0;
        for(String line : inputLines){
            //System.out.println(convert);
            line = line.trim();
            if(line.contains(" ")) continue; //??
            String[] nodes = line.split("|");

            String src = nodes[0].trim();
            String dest = nodes[1].trim();
            int start = idToIndex.get(src);
            int end = idToIndex.get(dest);
            edges[k] = new int[]{start, end};
            rates[k] = nodes[2].trim();
            k++;
        }
        boolean isCyclic = checkCyclic(n, edges);
        if(isCyclic){
            System.out.println("cyclic");
        }else{
            System.out.println("noncyclic");
        }

    }

    private static boolean checkCyclic(int n, int[][] edges){
        if(edges.length != n-1) return false;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        q.add(0);
        seen.add(0);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int nei : graph.get(node)){
                if(seen.contains(nei)){
                    continue;
                }
                seen.add(nei);
                q.add(nei);
            }
        }
        return seen.size()<=n;
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        ArrayList<String> inputLines = new ArrayList<>();
        while ((line = in.readLine()) != null) {
            //System.out.println(line);
            inputLines.add(line);
        }
        _ESG_IssuerGraph_.checkCycle_getMaxRating(inputLines);
    }
}
