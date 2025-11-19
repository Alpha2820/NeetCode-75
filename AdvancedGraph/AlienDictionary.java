package AdvancedGraph;

import java.util.*;

public class AlienDictionary {
  public static String alienOrder(String[] words) {
    Map<Character, Set<Character>> adjList = new HashMap<>();
    int[] inDegree = new int[26];
    Arrays.fill(inDegree, -1);

    for (String word : words) {
      for (char c : word.toCharArray()) {
        adjList.putIfAbsent(c, new HashSet<>());
        inDegree[c - 'a'] = 0;
      }
    }

    for (int i = 0; i < words.length - 1; i++) {
      String word1 = words[i];
      String word2 = words[i + 1];
      int minLength = Math.min(word1.length(), word2.length());
      boolean foundDifference = false;

      for (int j = 0; j < minLength; j++) {
        char c1 = word1.charAt(j);
        char c2 = word2.charAt(j);
        if (c1 != c2) {
          if (!adjList.get(c1).contains(c2)) {
            adjList.get(c1).add(c2);
            inDegree[c2 - 'a']++;
          }
          foundDifference = true;
          break;
        }
      }

      if (!foundDifference && word1.length() > word2.length()) {
        return "";
      }
    }

    Queue<Character> queue = new LinkedList<>();
    for (char c : adjList.keySet()) {
      if (inDegree[c - 'a'] == 0) {
        queue.offer(c);
      }
    }

    StringBuilder result = new StringBuilder();
    while (!queue.isEmpty()) {
      char current = queue.poll();
      result.append(current);
      for (char neighbor : adjList.get(current)) {
        inDegree[neighbor - 'a']--;
        if (inDegree[neighbor - 'a'] == 0) {
          queue.offer(neighbor);
        }
      }
    }

    if (result.length() != adjList.size()) {
      return "";
    }

    return result.toString();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    String[] words = new String[n];
    for (int i = 0; i < n; i++) {
      words[i] = sc.nextLine();
    }
    String result = alienOrder(words);
    System.out.println(result);
    sc.close();
  }
}
// Time Complexity: O(C + V) where C is the total number of characters in all
// words and V is the number of unique characters
// Space Complexity: O(C + V)
