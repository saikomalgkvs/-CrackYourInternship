// Problem link: https://leetcode.com/problems/evaluate-division/

import java.util.*;
// import javafx.util.Pair;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // BUILDING A DIRECTED GRAPH
        Map<String, List<Pair<String, Double>>> map = new HashMap<>(); // Key -> dividend, Value -> (divisor, value of dividend/divisor);

        for(int i=0; i<equations.size(); i++){
            String from = equations.get(i).get(0); // dividend
            String to = equations.get(i).get(1); // divisor

            // for equation a/b put a -> b and b -> a in graph
            if(map.containsKey(from)) map.get(from).add(new Pair(to, values[i]));
            else{
                List<Pair<String,Double>> list = new ArrayList<>();
                list.add(new Pair(to, values[i]));
                map.put(from, list);
            }

            if(map.containsKey(to)) map.get(to).add(new Pair(from, 1/values[i]));
            else{
                List<Pair<String,Double>> list = new ArrayList<>();
                list.add(new Pair(from, 1/values[i]));
                map.put(to, list);
            }
        }

        // EVALUATING EACH QUERY USING DFS

        // a/c can be obtained by multiplying a/b * b/c;
        // to find a/c perform dfs from a until we find c, and store values in stack
        int n = queries.size();
        double[] result = new double[n];
        Set<String> vis = new HashSet<>(); // contains already visited nodes.

        for(int i=0; i<n; i++){ // performing dfs on each query
            List<String> query = queries.get(i);

            String p = query.get(0); // dividend
            String q = query.get(1); // divisor

            if(!map.containsKey(p) || !map.containsKey(q)) result[i] = -1; // handles quries with invalid nodes
            else if(p.equals(q)) result[i] = 1; // if both dividend and divisor are equal;
            else{
                result[i] = dfs(p,q,map, new Stack<>(), vis);
            }
            vis = new HashSet<>(); // clear all visited nodes from set beform perfoming dfs on new query.
        }
        return result;
    }
    private double dfs(String start, String end, Map<String, List<Pair<String, Double>>> map, Stack<Double> stack, Set<String> vis){

        if(vis.contains(start)) return -1; // already visited
        vis.add(start); // mark as visit

        if(start.equals(end)){ // when start and end are equal, multiply all values in stack and return
            double ans = 1;
            while(!stack.isEmpty()) ans *= stack.pop();
            return ans;
        }

        for(Pair<String,Double> nextNode : map.get(start)){
            stack.push(nextNode.getValue());
            double ans = dfs(nextNode.getKey(), end, map, stack, vis);
            if(ans != -1) return ans;
            stack.pop();
        }
        return -1; // default
    }   
}
