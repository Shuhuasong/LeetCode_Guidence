package Design;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _855_ExamRoom {

    //Time = O(n)
    //Time = O(n)
    List<Integer> list = new ArrayList<>();
    int n;
    public _855_ExamRoom(int n) {
        this.n = n;
    }

    public int seat() {
        if(list.size()==0){
            list.add(0);
            return 0;
        }
        int maxDist = Math.max(list.get(0), n-1-list.get(list.size()-1));
        for(int i=0; i<list.size()-1; i++){
            maxDist = Math.max(maxDist, (list.get(i+1)-list.get(i))/2);
        }
        //need to check the maxDist == list.get(0) when previous list.get(0) was deleted
        if(list.get(0)==maxDist){
            list.add(0, 0);
            return 0;
        }
        for(int i=0; i<list.size()-1; i++){
            if((list.get(i+1)-list.get(i))/2==maxDist){
                int insertIdx = (list.get(i+1)+list.get(i))/2;
                list.add(i+1, insertIdx);
                return list.get(i+1);
            }
        }
        list.add(n-1);
        return n-1;
    }

    public void leave(int p) {
        for(int i=0; i<list.size(); i++){
            if(list.get(i)==p){
                list.remove(i);
            }
        }
    }

    /*
    //Time = O(logn)
   //Time = O(n)
    TreeSet<Integer> students;
    int n;
    public ExamRoom(int n) {
       this.n = n;
       students = new TreeSet<>();
    }

    public int seat() {
        //student: the position for the next student to sit down
        int student = 0;
        if(students.size() > 0){
            //considering the left-most distance
            int dist = students.first();
            Integer prev = null;
            for(Integer s : students){
                if(prev != null){
                    //compare the dist of two adjacent students
                    int newDist = (s-prev)/2;
                    if(newDist > dist){
                        dist = newDist;
                        student = prev + newDist;
                    }
                }
                prev = s;
            }
            if(n-1-students.last() > dist){
                student = n-1;
            }
        }
        students.add(student);
        return student;
    }

    public void leave(int p) {
        students.remove(p);
    }
     */

}
