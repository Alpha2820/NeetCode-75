import java.util.*;

public class WordBreak {
  public static boolean canBreak(String s, List<String> wordDict) {
    int length = s.length();
    boolean dp[] = new boolean[s.length() + 1];
    dp[length] = true;
    for (int i = length - 1; i >= 0; i--) {
      for (String word : wordDict) {
        int wordLength = word.length();
        if (i + wordLength <= length && s.substring(i, i + wordLength).equals(word)) {
          dp[i] = dp[i + wordLength];
        }
        if (dp[i]) {
          break;
        }
      }
    }
    return dp[0];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the string");
    String s = sc.nextLine();
    System.out.println("Enter the number of words in the dictionary");
    int n = sc.nextInt();
    sc.nextLine();
    List<String> wordDict = new ArrayList<>();
    System.out.println("Enter the words in the dictionary");
    for (int i = 0; i < n; i++) {
      String word = sc.nextLine();
      wordDict.add(word);
    }
    boolean result = canBreak(s, wordDict);
    if (result) {
      System.out.println("The string can be segmented into words from the dictionary");
    } else {
      System.out.println("The string cannot be segmented into words from the dictionary");
    }
    sc.close();
  }
}
