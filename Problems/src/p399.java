import java.util.*;

/**
 * Created by Valued Customer on 9/17/2016.
 * 399. Evaluate Division
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real
 * number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

 Example:
 Given a / b = 2.0, b / c = 3.0.
 queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 return [6.0, 0.5, -1.0, 1.0, -1.0 ].

 The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries ,
 where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

 According to the example above:

 equations = [ ["a", "b"], ["b", "c"] ],
 values = [2.0, 3.0],
 queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 */
public class p399 {
    class Value {
        String name;
        boolean visited;
        Map<Value, Double> map;
        public Value(String name) {
            this.name = name;
            this.map = new HashMap<>();
            this.visited = false;
        }
    }
    double ans = -1.0;
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Value> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            double quotient = values[i];
            map.putIfAbsent(equation[0], new Value(equation[0]));
            map.putIfAbsent(equation[1], new Value(equation[1]));
            Value nom = map.get(equation[0]), denom = map.get(equation[1]);
            nom.map.putIfAbsent(denom, quotient);
            denom.map.putIfAbsent(nom, 1.0 / quotient);
        }
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            if (map.containsKey(query[0]) && map.containsKey(query[1])) {
                dfs(map.get(query[0]), map.get(query[1]), 1.0);
                result[i] = ans;
                ans = -1.0;
            } else {
                result[i] = -1.0;
            }
        }
        return result;
    }

    private void dfs(Value value, Value target, double v) {
        if (value == target) {
            ans = v;
            return;
        }
        value.visited = true;
        for (Value neighbor: value.map.keySet()) {
            if (!neighbor.visited) {
                double quotient = value.map.get(neighbor);
                dfs(neighbor, target, v * quotient);
            }
        }
        value.visited = false;
    }
}
