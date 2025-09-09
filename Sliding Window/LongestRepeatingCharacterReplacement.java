import java.util.*;

public class LongestRepeatingCharacterReplacement {
  public static int maxLen(String s, int k) {
    HashSet<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      set.add(s.charAt(i));
    }
    int max = 0;
    for (char c : set) {
      int left = 0;
      int count = 0;
      for (int right = 0; right < s.length(); right++) {
        if (s.charAt(right) == c) {
          count++;
        }
        while ((right - left + 1) - count > k) {
          if (s.charAt(left) == c) {
            count--;
          }
          left++;
        }
        max = Math.max(max, right - left + 1);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the string");
    String s = sc.next();
    System.out.println("Enter the value of k");
    int k = sc.nextInt();
    System.out.println("The length of longest substring after replacement is " + maxLen(s, k));
    sc.close();
  }

}
