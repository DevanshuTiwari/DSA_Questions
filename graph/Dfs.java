package graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static graph.GraphTemplate.buildGraph;

public class Dfs {
    public static void main(String[] args) throws IOException {

        GraphTemplate.FastScanner fs = new GraphTemplate.FastScanner();
        List<List<Integer>> adj = buildGraph(3, 3, fs);

        boolean[] visited = new boolean[4];
        List<Integer> ans = new ArrayList<>();

        dfsTraversal(adj, 1, visited, ans);
        System.out.println(ans);

    }

    private static void dfsTraversal(List<List<Integer>> adj, int node, boolean[] visited, List<Integer> dfsList) {
        visited[node] = true;
        dfsList.add(node);

        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                dfsTraversal(adj, neighbour, visited, dfsList);
            }
        }
    }
}
