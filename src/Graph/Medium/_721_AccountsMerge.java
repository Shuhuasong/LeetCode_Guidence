package Graph.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _721_AccountsMerge {

    //Time = O(NK*log(NK)), N=#of acounts, K=#ofemails for each account
    //worst case: when all accounts are belong to one person
    //Space = O(NK)

    Map<String, HashSet<String>> graph;
    Map<String, String> mailToName;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        graph = new HashMap<>();
        mailToName = new HashMap<>();
        buildGraph(accounts);
        HashSet<String> visited = new HashSet<>();
        List<List<String>> results = new ArrayList<>();
        for(String mail : mailToName.keySet()){
            if(visited.contains(mail)) continue;
            List<String> tempList = new ArrayList<>();
            tempList.add(mail);

            dfs(mail, tempList, visited);

            Collections.sort(tempList);
            String name = mailToName.get(mail);
            tempList.add(0, name);
            results.add(tempList);
        }
        return results;
    }

    private void dfs(String mail, List<String> list, HashSet<String> visited){
        if(graph.get(mail)==null || graph.get(mail).size()==0) return;
        visited.add(mail);
        for(String neigh : graph.get(mail)){
            if(visited.contains(neigh)) continue;
            list.add(neigh);
            dfs(neigh, list, visited);
        }
    }


    private void buildGraph(List<List<String>> accounts){
        for(List<String> ac : accounts){
            String name = ac.get(0);
            for(int i=1; i<ac.size(); i++){
                String mail = ac.get(i);
                graph.putIfAbsent(mail, new HashSet<>());
                mailToName.put(mail, name);
                if(i==1) continue;
                String prevMail = ac.get(i-1);
                graph.get(mail).add(prevMail);
                graph.get(prevMail).add(mail);
            }
        }
    }
}

/*  Union Find
//Use map to store the node and its parent
     class UnionFind {
        Map<String, String> root = new HashMap<>();
        public String find(String x){
            String xParent = root.getOrDefault(x, x);
            if(!xParent.equals(x)) xParent = find(xParent);
            root.put(x, xParent);
            return root.get(x);
        }
        public void union(String x, String y){
            root.put(find(x), find(y));
        }
    }
   //Seperate each unique email and store them into map with corresponding name
    //And union each email with it primary email
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind UF = new UnionFind();
        Map<String, String> emailToName = new HashMap<>();
        for(List<String> account : accounts){
            String name = account.get(0);
            String mainEmail = account.get(1);
            for(int i=1; i<account.size(); i++){
                String currEmail = account.get(i);
                emailToName.put(currEmail, name);
                UF.union(currEmail, mainEmail);
            }
        }
        // key = primary email, value = email list under same account
        Map<String, List<String>> mergeAccount = new HashMap<>();
        for(String mail : emailToName.keySet()){
            String mainEmail = UF.find(mail);
            mergeAccount.putIfAbsent(mainEmail, new ArrayList<>());
            mergeAccount.get(mainEmail).add(mail);
        }
        //Sort emails and add name for each list
        List<List<String>> results = new ArrayList<>();
        for(List<String> mails : mergeAccount.values()){
            Collections.sort(mails);
            String name = emailToName.get(mails.get(0));
            List<String> listR = new ArrayList<>();
            listR.add(name);
            listR.addAll(mails);
            results.add(listR);
        }
        return results;
    }

 */

/*
Method--Graph
DFS Traversal:
1)  Build Graph, use Adjacent List
    Map<mail, Set<mails>>: key=mail, value=set of mail belongs the same person
    Map<mail, Name> : key=mail, value=mail's owner
2)  the Map<mail, Name> contains all the mails with corresponding owner
    Use DFS to find other mails in the same group
    Set<mail> visited ==> to make sure we are not visited the same mail again
    List<mail> tempList: add the current mail into tempList to the DFS(to find neighbors)

["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],

["Mary","mary@mail.com"],

["John","johnnybravo@mail.com"]

<"johnsmith@mail.com", "John">

---two accounts belong to the same person if the accounts have an email in common===> then merge
---one account must belongs to only one person
---cannot just use the user's name to determine,since different users may have the same name.
---.converting the input into a graph
---Emails can be represented as nodes, and an edge between nodes will signify that they belong to the same
person

*/
