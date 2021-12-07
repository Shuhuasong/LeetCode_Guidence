package UnionFind;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _2092_FindAllPeopleWithSecret {

    class UnionFind{
        int[] parents, rank;
        public UnionFind(int n){
            parents = new int[n];
            for(int i=0; i<n; i++){
                parents[i] = i;
            }
        }

        public int find(int x){
            if(parents[x] != x){
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX!=rootY){
                parents[rootX] = rootY;
            }

        }

        public boolean isConnect(int a, int b){
            return find(a)==find(b);
        }

        public void reset(int a){
            parents[a] = a;
        }

    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b)->a[2]-b[2]);
        int m = meetings.length;
        UnionFind UF = new UnionFind(n);
        UF.union(0, firstPerson);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        visited.add(firstPerson);

        for(int i=0; i<m; i++){
            int currTime = meetings[i][2];
            //Uninon the two person in the same meeting
            for(int j=i; j<m && meetings[j][2]==currTime; j++){
                int a = meetings[j][0], b = meetings[j][1];
                UF.union(a, b);
            }
            int k = i;
            //after union all the person at currTime, we check if they all have common parent 0
            //if Yes, they are in the same group, if not , they are int hte different group;
            for( ;k<m && meetings[k][2]==currTime; k++){
                if(UF.isConnect(0, meetings[k][0]) || UF.isConnect(0, meetings[k][1])){
                    visited.add(meetings[k][0]);
                    visited.add(meetings[k][1]);
                }else{
                    //both a and b are not shared the secret, so we set the group to itself
                    UF.reset(meetings[k][0]);
                    UF.reset(meetings[k][1]);
                }
            }
            i = k-1; //i need to go back to (k-1) index
        }
        List<Integer> results = new ArrayList<>();
        for(int p : visited) results.add(p);
        return results;
    }

}
