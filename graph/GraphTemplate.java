package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GraphTemplate {

    /* ========== FAST INPUT READER ========== */
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
    }

    // Unweighted Graph
    static List<List<Integer>> buildGraph(int n, int m, FastScanner fs) throws IOException {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u); // Remove if directed
        }

        return graph;
    }

    // Weighted Graph
    static List<List<int[]>> buildWeightedGraph(int n, int m, FastScanner fs) throws IOException {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            int w = fs.nextInt();
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w}); // Remove if directed
        }

        return graph;
    }

    // Grid Input
    static int[][] readGrid(int rows, int cols, FastScanner fs) throws IOException {
        int[][] grid = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                grid[i][j] = fs.nextInt();

        return grid;
    }

    /* ========== OUTPUT UTILITIES ========== */

    // Print single value
    static void print(int x) {
        System.out.println(x);
    }

    static void print(long x) {
        System.out.println(x);
    }

    static void print(boolean x) {
        System.out.println(x);
    }

    static void print(String s) {
        System.out.println(s);
    }

    // Print 1D Array
    static void printArray(int[] arr) {
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }

    // Print 2D Array / Grid
    static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    // Print List<Integer>
    static void printList(List<Integer> list) {
        for (int x : list)
            System.out.print(x + " ");
        System.out.println();
    }

    // Print List<List<Integer>>
    static void printListOfLists(List<List<Integer>> list) {
        for (List<Integer> inner : list) {
            for (int x : inner)
                System.out.print(x + " ");
            System.out.println();
        }
    }
}
