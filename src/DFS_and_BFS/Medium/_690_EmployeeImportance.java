package DFS_and_BFS.Medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _690_EmployeeImportance {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    Map<Integer, Employee> map = new HashMap<>();
    int total = 0;
    public int getImportance(List<Employee> employees, int id) {
        for(Employee emp : employees){
            map.put(emp.id, emp);
        }
        Employee currEmp = map.get(id);
        dfs(id, currEmp);
        return total;
    }

    private void dfs(int empId, Employee emp){
        if(emp==null) return;
        total += emp.importance;
        for(int eId : emp.subordinates){
            Employee subEmp = map.get(eId);
            dfs(eId, subEmp);
        }
    }
}
