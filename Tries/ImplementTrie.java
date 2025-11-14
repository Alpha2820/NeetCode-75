package Tries;

import java.util.*;

public class ImplementTrie {
  // Placeholder for Trie implementation
  public class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
  }

  private TrieNode root;

  public ImplementTrie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode node = root;
    for (char ch : word.toCharArray()) {
      node.children.putIfAbsent(ch, new TrieNode());
      node = node.children.get(ch);
    }
    node.isEndOfWord = true;
  }

  public boolean search(String word) {
    TrieNode node = root;
    for (char ch : word.toCharArray()) {
      if (!node.children.containsKey(ch)) {
        return false;
      }
      node = node.children.get(ch);
    }
    return node.isEndOfWord;
  }

  public boolean startsWith(String prefix) {
    TrieNode node = root;
    for (char ch : prefix.toCharArray()) {
      if (!node.children.containsKey(ch)) {
        return false;
      }
      node = node.children.get(ch);
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ImplementTrie trie = new ImplementTrie();
    System.out.println("Enter words to insert into the Trie (space-separated):");
    String[] wordsToInsert = scanner.nextLine().split(" ");
    for (String word : wordsToInsert) {
      trie.insert(word);
      System.out.println("Inserted: " + word);
    }
    System.out.println("Enter a word to search in the Trie:");
    String wordToSearch = scanner.nextLine();
    boolean found = trie.search(wordToSearch);
    System.out.println("Word '" + wordToSearch + "' found: " + found);
    System.out.println("Enter a prefix to check in the Trie:");
    String prefixToCheck = scanner.nextLine();
    boolean startsWith = trie.startsWith(prefixToCheck);
    System.out.println("Prefix '" + prefixToCheck + "' exists: " + startsWith);
    scanner.close();
  }
}
