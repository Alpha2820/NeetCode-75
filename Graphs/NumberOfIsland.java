package Graphs;

import java.util.*;

public class NumberOfIsland {
  public static int numOfIsland(char[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    int isLand = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == '1') {
          isLand++;
          dfs(grid, i, j);
        }
      }
    }
    return isLand;
  }

  public static void dfs(char[][] grid, int row, int col) {
    if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
      return;
    }
    grid[row][col] = '0';
    dfs(grid, row + 1, col);
    dfs(grid, row - 1, col);
    dfs(grid, row, col + 1);
    dfs(grid, row, col - 1);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter number of rows:");
    int rows = Integer.parseInt(scanner.nextLine());
    System.out.println("Enter number of columns:");
    int cols = Integer.parseInt(scanner.nextLine());
    char[][] grid = new char[rows][cols];
    System.out.println("Enter the grid row by row (use '1' for land and '0' for water):");
    for (int i = 0; i < rows; i++) {
      String line = scanner.nextLine();
      grid[i] = line.toCharArray();
    }
    int result = numOfIsland(grid);
    System.out.println("Number of Islands: " + result);
    scanner.close();
  }

}
// Time Complexity: O(M * N) where M is the number of rows and N is the number
// of columns
// Space Complexity: O(M * N) in the worst case for the recursion stack