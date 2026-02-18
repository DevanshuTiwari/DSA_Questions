package graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static graph.GraphTemplate.buildGraph;
import static graph.GraphTemplate.FastScanner;

public class Bfs {
    public static void main(String[] args) throws IOException {

        FastScanner fs = new FastScanner();
        List<List<Integer>> adj = buildGraph(3, 3, fs);

        List<Integer> ans = bfsTraversal(adj, 1, 3);
        System.out.println(ans);

    }

    private static List<Integer> bfsTraversal(List<List<Integer>> adj, int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> bfsList = new ArrayList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfsList.add(node);

            for (int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }

        return bfsList;
    }
}