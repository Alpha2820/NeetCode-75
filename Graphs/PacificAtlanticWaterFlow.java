package Graphs;

import java.util.*;

public class PacificAtlanticWaterFlow {
  // Placeholder for Pacific Atlantic Water Flow implementation
  public static List<List<Integer>> pacificAtlantic(int[][] heights) {
    int rows = heights.length;
    int cols = heights[0].length;
    List<List<Integer>> result = new ArrayList<>();
    boolean[][] pacificReachable = new boolean[rows][cols];
    boolean[][] atlanticReachable = new boolean[rows][cols];
    for (int i = 0; i < rows; i++) {
      dfs(heights, pacificReachable, i, 0);
      dfs(heights, atlanticReachable, i, cols - 1);
    }
    for (int j = 0; j < cols; j++) {
      dfs(heights, pacificReachable, 0, j);
      dfs(heights, atlanticReachable, rows - 1, j);
    }
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (pacificReachable[i][j] && atlanticReachable[i][j]) {
          result.add(Arrays.asList(i, j));
        }
      }
    }
    return result;
  }

  public static void dfs(int[][] heights, boolean[][] reachable, int row, int col) {
    int rows = heights.length;
    int cols = heights[0].length;
    reachable[row][col] = true;
    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    for (int[] dir : directions) {
      int newRow = row + dir[0];
      int newCol = col + dir[1];
      if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
          !reachable[newRow][newCol] && heights[newRow][newCol] >= heights[row][col]) {
        dfs(heights, reachable, newRow, newCol);
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter number of rows:");
    int rows = Integer.parseInt(scanner.nextLine());
    System.out.println("Enter number of columns:");
    int cols = Integer.parseInt(scanner.nextLine());
    int[][] heights = new int[rows][cols];
    System.out.println("Enter the heights grid row by row (space-separated):");
    for (int i = 0; i < rows; i++) {
      String[] line = scanner.nextLine().split(" ");
      for (int j = 0; j < cols; j++) {
        heights[i][j] = Integer.parseInt(line[j]);
      }
    }
    List<List<Integer>> result = pacificAtlantic(heights);
    System.out.println("Cells that can flow to both oceans: " + result);
    scanner.close();
  }
}
