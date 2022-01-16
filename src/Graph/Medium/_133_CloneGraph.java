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
}
