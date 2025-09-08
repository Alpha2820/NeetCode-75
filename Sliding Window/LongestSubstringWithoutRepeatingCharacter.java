import java.util.*;

public class LongestSubstringWithoutRepeatingCharacter {
  public static int lengthOfLongestSubstring(String s) {
    HashSet<Character> set = new HashSet<>();
    int left = 0;
    int length = 0;
    for (int right = 0; right < s.length(); right++) {
      while (set.contains(s.charAt(right))) {
        set.remove(s.charAt(left));
        right++;
      }
      set.add(s.charAt(right));
      length = Math.max(length, right - left + 1);
    }
    return length;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the string");
    String s = sc.next();
    System.out.println("The length of longest substring without repeating character is " + lengthOfLongestSubstring(s));
    sc.close();
  }
}