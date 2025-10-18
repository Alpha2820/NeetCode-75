import java.util.*;

public class ClimbingStairs {
  public static int stairs(int n) {
    if (n <= 2) {
      return n;
    }
    int dp[] = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of stairs");
    int n = sc.nextInt();
    int result = stairs(n);
    System.out.println("The number of ways to climb to the top is : " + result);
    sc.close();
  }

}
