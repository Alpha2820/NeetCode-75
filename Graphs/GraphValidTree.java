package Graphs;

import java.util.*;

public class GraphValidTree {
  public static boolean validTree(int n, int[][] edges) {
    if (edges.length > n - 1) {
      return false;
    }
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjList.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      adjList.get(edge[0]).add(edge[1]);
      adjList.get(edge[1]).add(edge[0]);
    }
    HashSet<Integer> visited = new HashSet<>();
    if (!dfs(0, -1, adjList, visited)) {
      return false;
    }
    return visited.size() == n;
  }

  public static boolean dfs(int node, int parent, List<List<Integer>> adjList, HashSet<Integer> visited) {
    if (visited.contains(node)) {
      return false;
    }
    visited.add(node);
    for (int neighbor : adjList.get(node)) {
      if (neighbor == parent) {
        continue;
      }
      if (!dfs(neighbor, node, adjList, visited)) {
        return false;
      }
    }
    return true;
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
    boolean result = validTree(n, edges);
    System.out.println(result);
    sc.close();
  }
}
// Time Complexity: O(V + E) where V is the number of vertices and E is the
// number of edges
// Space Complexity: O(V) for the adjacency list and visited set