import java.util.*;

public class DecodeWays {
  public static int findWays(String s) {
    if (s.length() == 0 || s == null) {
      return 0;
    }
    int dp[] = new int[s.length() + 1];
    dp[0] = 1;
    if (s.charAt(0) != '0') {
      dp[1] = 1;
    } else {
      dp[1] = 0;
    }
    for (int i = 2; i <= s.length(); i++) {
      int one = Integer.valueOf(s.substring(i - 1, i));
      int two = Integer.valueOf(s.substring(i - 2, i));
      if (one >= 1 && one <= 9) {
        dp[i] += dp[i - 1];
      }
      if (two >= 10 && two <= 26) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[s.length()];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the string");
    String s = sc.nextLine();
    int result = findWays(s);
    System.out.println("The number of ways to decode the string is : " + result);
    sc.close();
  }
}
