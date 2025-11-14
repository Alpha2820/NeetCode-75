package Tries;

import java.util.*;

public class WordSearchII {
  public class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    String word = null;
  }

  public TrieNode root;

  public WordSearchII() {
    root = new TrieNode();
  }

  public void addWord(String word) {
    TrieNode node = root;
    for (char ch : word.toCharArray()) {
      node.children.putIfAbsent(ch, new TrieNode());
      node = node.children.get(ch);
    }
    node.word = word;
  }

  public List<String> findWords(char[][] board, String[] words) {
    for (String word : words) {
      addWord(word);
    }
    Set<String> result = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        backtrack(board, i, j, root, result);
      }
    }
    return new ArrayList<>(result);
  }

  private void backtrack(char[][] board, int row, int col, TrieNode node, Set<String> result) {
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
      return;
    }
    char ch = board[row][col];
    if (!node.children.containsKey(ch)) {
      return;
    }
    node = node.children.get(ch);
    if (node.word != null) {
      result.add(node.word);
    }
    board[row][col] = '#';
    backtrack(board, row + 1, col, node, result);
    backtrack(board, row - 1, col, node, result);
    backtrack(board, row, col + 1, node, result);
    backtrack(board, row, col - 1, node, result);
    board[row][col] = ch;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter board rows (comma-separated, use no spaces):");
    String[] rowInputs = scanner.nextLine().split(",");
    char[][] board = new char[rowInputs.length][rowInputs[0].length()];
    for (int i = 0; i < rowInputs.length; i++) {
      board[i] = rowInputs[i].toCharArray();
    }
    System.out.println("Enter words to search (space-separated):");
    String[] words = scanner.nextLine().split(" ");
    WordSearchII wordSearchII = new WordSearchII();
    List<String> foundWords = wordSearchII.findWords(board, words);
    System.out.println("Words found in board: " + foundWords);
    scanner.close();
  }
}
