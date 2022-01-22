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
