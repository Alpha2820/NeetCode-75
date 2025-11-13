package BackTracking;

import java.util.*;

public class WordSearch {
  // Placeholder for Word Search implementation
  public int rows;
  public int cols;
  public boolean[][] visited;

  public static boolean exist(char[][] board, String word) {
    int rows = board.length;
    int cols = board[0].length;
    boolean[][] visited = new boolean[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (backtrack(board, word, 0, i, j, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean backtrack(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
    if (index == word.length()) {
      return true;
    }
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
        visited[row][col] || board[row][col] != word.charAt(index)) {
      return false;
    }

    visited[row][col] = true;

    boolean found = backtrack(board, word, index + 1, row + 1, col, visited) ||
        backtrack(board, word, index + 1, row - 1, col, visited) ||
        backtrack(board, word, index + 1, row, col + 1, visited) ||
        backtrack(board, word, index + 1, row, col - 1, visited);

    visited[row][col] = false;
    return found;
  }

  public static void main(String[] args) {
    // Placeholder for main method
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter board rows (comma-separated, use no spaces):");
    String[] rowInputs = scanner.nextLine().split(",");
    char[][] board = new char[rowInputs.length][rowInputs[0].length()];
    for (int i = 0; i < rowInputs.length; i++) {
      board[i] = rowInputs[i].toCharArray();
    }
    System.out.println("Enter the word to search:");
    String word = scanner.nextLine();
    boolean result = exist(board, word);
    System.out.println("Word exists in board: " + result);
    scanner.close();

  }

}
