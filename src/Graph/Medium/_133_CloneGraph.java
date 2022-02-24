package Graph.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _133_CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    //BFS  //Time = (N+M), N = # of nodes, M = # of edges
    public Node cloneGraph(Node node) {
        if(node==null) return node;
        Map<Node, Node> copyNodes = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        copyNodes.put(node, new Node(node.val, new ArrayList<>()));
        while(!q.isEmpty()){
            Node  curr = q.poll();
            for(Node oldNei : curr.neighbors){
                if(!copyNodes.containsKey(oldNei)){
                    copyNodes.put(oldNei, new Node(oldNei.val, new ArrayList<>()));
                    q.offer(oldNei);
                }
                copyNodes.get(curr).neighbors.add(copyNodes.get(oldNei));
            }
        }
        return copyNodes.get(node);
    }

    /*
     //DFS: Time = (N+M), N = # of nodes, M = # of edges
    public Node cloneGraph(Node node) {
        if(node==null) return node;
        Map<Node, Node> copyNodes = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        dfs(node, copyNodes, visited);
        return copyNodes.get(node);
    }
    private void dfs(Node node, Map<Node, Node> copyNodes, Set<Node> visited){
        if(visited.contains(node)) return;
        visited.add(node);
        copyNodes.put(node, new Node(node.val, new ArrayList<>()));
        for(Node oldNei : node.neighbors){
            if(!visited.contains(oldNei)){
                copyNodes.put(oldNei, new Node(oldNei.val, new ArrayList<>()));
                dfs(oldNei, copyNodes, visited);
            }
            copyNodes.get(node).neighbors.add(copyNodes.get(oldNei));
        }
    }
     */

    /*
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        List<Node> list = collectAllNodes(node);
        Map<Node, Node> map = copyEachNode(list);
        connectNeighbor(list, map);
        return map.get(node);
    }

    private List<Node> collectAllNodes(Node root){
        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        q.add(root);
        visited.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node currNode = q.poll();
                for(Node nei : currNode.neighbors){
                    if(visited.contains(nei)) continue;
                    q.add(nei);
                    visited.add(nei);
                }
            }
        }
        return new LinkedList<>(visited);
    }

    private Map<Node, Node> copyEachNode(List<Node> list){
        Map<Node, Node> map = new HashMap<>();
        for(Node node : list){
            map.put(node, new Node(node.val));
        }
        return map;
    }

    private void connectNeighbor(List<Node> list, Map<Node, Node> map){
        for(Node oriNode : list){
            Node copyNode = map.get(oriNode);
            List<Node> oriNei = oriNode.neighbors;
            for(Node nei : oriNei){
                copyNode.neighbors.add(map.get(nei));
            }
        }
    }

     */
}
