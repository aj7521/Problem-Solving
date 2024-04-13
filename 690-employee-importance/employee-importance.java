/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        return dfs(id, employees, map);
    }

    public int dfs(int id, List<Employee> employees, HashMap<Integer, Employee> map){
        Employee e = map.get(id);
        int count = e.importance;
        for(Integer it: e.subordinates){
            count += dfs(it, employees, map);
        }
        return count;
    }
}