import java.util.*;

public class validPalindrome {

  public static boolean isValidPalindrome(String str) {
    str = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
    int left = 0;
    int right = str.length() - 1;
    while (left < right) {
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the String");
    String str = sc.nextLine();
    boolean result = isValidPalindrome(str);
    System.out.println("Is the Given String a Valid Palindrome : " + result);
    sc.close();
  }
}
