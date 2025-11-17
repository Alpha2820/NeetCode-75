package Graphs;

import java.util.*;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
  public static int countComponents(int n, int arr[][]) {
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjList.add(new ArrayList<>());
    }
    for (int[] edge : arr) {
      adjList.get(edge[0]).add(edge[1]);
      adjList.get(edge[1]).add(edge[0]);
    }
    boolean[] visited = new boolean[n];
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(i, adjList, visited);
        count++;
      }
    }
    return count;
  }

  public static void dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
    visited[node] = true;
    for (int neighbor : adjList.get(node)) {
      if (!visited[neighbor]) {
        dfs(neighbor, adjList, visited);
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] edges = new int[m][2];
    for (int i = 0; i < m; i++) {
      edges[i][0] = sc.nextInt();
      edges[i][1] = sc.nextInt();
    }
    int result = countComponents(n, edges);
    System.out.println(result);
    sc.close();
  }
}
