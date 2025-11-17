package Graphs;

import java.util.*;

public class CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      adjList.add(new ArrayList<>());
    }
    for (int[] pre : prerequisites) {
      adjList.get(pre[1]).add(pre[0]);
    }
    int[] visited = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      if (hasCycle(i, adjList, visited)) {
        return false;
      }
    }
    return true;
  }

  public static boolean hasCycle(int node, List<List<Integer>> adjList, int[] visited) {
    if (visited[node] == 1) {
      return true;
    }
    if (visited[node] == 2) {
      return false;
    }
    visited[node] = 1;
    for (int neighbor : adjList.get(node)) {
      if (hasCycle(neighbor, adjList, visited)) {
        return true;
      }
    }
    visited[node] = 2;
    return false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numCourses = sc.nextInt();
    int m = sc.nextInt();
    int[][] prerequisites = new int[m][2];
    for (int i = 0; i < m; i++) {
      prerequisites[i][0] = sc.nextInt();
      prerequisites[i][1] = sc.nextInt();
    }
    CourseSchedule cs = new CourseSchedule();
    boolean result = cs.canFinish(numCourses, prerequisites);
    System.out.println(result);
    sc.close();
  }
}
