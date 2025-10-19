import java.util.*;

public class LongestPalidromicString {
  public static String LPS(String s) {
    int result = 0;
    int rIndex = 0;
    for (int i = 0; i < s.length(); i++) {
      int left = i;
      int right = i;
      // for Even length
      while ((left >= 0) && (right < s.length() && (s.charAt(left) == s.charAt(right)))) {
        if ((right - left + 1) > result) {
          result = right - left + 1;
          rIndex = left;
        }
        left--;
        right++;
      }
      left = i;
      right = i + 1;
      // for Odd Length
      while ((left >= 0) && (right < s.length()) && (s.charAt(left) == s.charAt(right))) {
        if ((right - left + 1) > result) {
          result = right - left + 1;
          rIndex = left;
        }
        left--;
        right++;
      }
    }
    return s.substring(rIndex, rIndex + result);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the string");
    String s = sc.nextLine();
    String result = LPS(s);
    System.out.println("The longest palindromic substring is : " + result);
    sc.close();
  }
}
