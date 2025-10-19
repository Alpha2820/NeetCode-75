import java.util.*;

public class PalindromeSubstring {

  public static int countPalindromicSubstring(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      int left = i;
      int right = i;
      // for even length
      while ((left >= 0) && (right < s.length()) && (s.charAt(left) == s.charAt(right))) {
        count++;
        left--;
        right++;
      }
      // for odd length
      while ((left >= 0) && (right < s.length()) && (s.charAt(left) == s.charAt(right))) {
        count++;
        left--;
        right++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the string");
    String s = sc.nextLine();
    int result = countPalindromicSubstring(s);
    System.out.println("The count of palindromic substring is : " + result);
    sc.close();
  }
}
