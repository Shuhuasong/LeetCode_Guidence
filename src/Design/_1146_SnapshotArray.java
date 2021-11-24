package Design;

import java.util.TreeMap;

/**
 * Created by Shuhua Song
 */
public class _1146_SnapshotArray {
    TreeMap<Integer, Integer>[] tree;
    int snapId = 0;
    public _1146_SnapshotArray(int length) {
        tree = new TreeMap[length];
        for(int i=0; i<length; i++){
            tree[i] = new TreeMap<Integer, Integer>();
            tree[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        tree[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        return tree[index].floorEntry(snap_id).getValue();
        //  return tree[index].get(snap_id);
    }
}

/*
Possible Solution:
Record the whole array, one version at a time
Use List<int[]> or TreeMap<>[]
Pros : get the special version index value ==> O(1)
       snap[index] = val ===> O(1)
Cons : Snap ()
       int[] ==> cause a lot of duplicate in Copy of snap value ==> Memory Limit Exceed (With much useless information)

Optimal Solution:  Only save modified information, one element one version history
because every time we call snap(), so
        Version SnapId are not necessarily consistent, not greater thtan snap_id == Find suitable version
E.g   for index 0, we only record
      version 1    find version 3 by using floorEntry(), because the version 2,3 are same after changed version 1
      version 7    keep the same from 6
      */

