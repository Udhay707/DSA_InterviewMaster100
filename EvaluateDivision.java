import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision{

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for(int i=0; i<equations.size(); i++){
            Map<String, Double> valueSet = graph.getOrDefault(equations.get(i).get(0), new HashMap<>());
            valueSet.put(equations.get(i).get(1), values[i]);
            graph.put(equations.get(i).get(0), valueSet);

            Map<String, Double> valueSet1 = graph.getOrDefault(equations.get(i).get(1), new HashMap<>());
            valueSet1.put(equations.get(i).get(0), 1/values[i]);
            graph.put(equations.get(i).get(1), valueSet1);


        }

        double[] ans = new double[queries.size()];

        for(int i=0; i<queries.size(); i++){
            String numerator = queries.get(i).get(0);
            String denominator = queries.get(i).get(1);
            if(numerator.equals(denominator) && graph.containsKey(numerator)){
                ans[i] = 1;
            } else if(!graph.containsKey(numerator)){
                ans[i] =  -1;
            }
            else{
                ans[i] = dfs(numerator, denominator,  graph, new HashSet<>(), 1);
            }
        }
            
        return ans;
                    
    }
            
    private double dfs(String numerator, 
                       String denominator, 
                       Map<String, Map<String, Double>> graph, 
                       Set<String> visited, 
                       double val) {

        if(visited.contains(numerator)){
            return -1;
        }
        if(!graph.containsKey(numerator)){
            return -1;
        }

        if(graph.get(numerator).containsKey(denominator)){
            return val * graph.get(numerator).get(denominator);
        }

        visited.add(numerator);

        for(var entry : graph.get(numerator).entrySet()){
            double ans = dfs(entry.getKey(), denominator, graph, visited, val * entry.getValue());
            if(ans != -1){
                return ans;
            }
        }


        return -1;
        
    }

    public static void main(String[] args) {
        EvaluateDivision evaluateDivision = new EvaluateDivision();
        List<List<String>> equation = List.of(List.of("a", "b"), List.of("b", "c"));
        double[] values = new double[]{2.0,3.0};
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"));
        var output = evaluateDivision.calcEquation(equation, values, queries);
        System.out.println(Arrays.toString(output));
        
    }
    

}