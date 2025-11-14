package Tries;

import java.util.*;

public class DesignAddAndSearchWords {
  // Placeholder for Design Add and Search Words implementation
  public class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
  }

  public TrieNode root;

  public DesignAddAndSearchWords() {
    root = new TrieNode();
  }

  public void addWord(String word) {
    TrieNode node = root;
    for (char ch : word.toCharArray()) {
      node.children.putIfAbsent(ch, new TrieNode());
      node = node.children.get(ch);
    }
    node.isEndOfWord = true;
  }

  public boolean search(String word) {
    return searchInNode(word, root);
  }

  private boolean searchInNode(String word, TrieNode node) {
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (ch == '.') {
        for (char x : node.children.keySet()) {
          if (searchInNode(word.substring(i + 1), node.children.get(x))) {
            return true;
          }
        }
        return false;
      } else {
        if (!node.children.containsKey(ch)) {
          return false;
        }
        node = node.children.get(ch);
      }
    }
    return node.isEndOfWord;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    DesignAddAndSearchWords wordDictionary = new DesignAddAndSearchWords();
    System.out.println("Enter words to add to the Word Dictionary (space-separated):");
    String[] wordsToAdd = scanner.nextLine().split(" ");
    for (String word : wordsToAdd) {
      wordDictionary.addWord(word);
      System.out.println("Added: " + word);
    }
    System.out.println("Enter a word to search in the Word Dictionary (use '.' as wildcard):");
    String wordToSearch = scanner.nextLine();
    boolean found = wordDictionary.search(wordToSearch);
    System.out.println("Word found: " + found);
    scanner.close();
  }

}
