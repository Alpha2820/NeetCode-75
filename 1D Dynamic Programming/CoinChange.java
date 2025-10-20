import java.util.*;

public class CoinChange {
  public static int waysToChange(int coins[], int amount) {
    int dp[] = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 1; i < amount + 1; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
        }
      }
    }
    if (dp[amount] == amount + 1) {
      return -1;
    }
    return dp[amount];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of coins");
    int n = sc.nextInt();
    int coins[] = new int[n];
    System.out.println("Enter the coin values");
    for (int i = 0; i < n; i++) {
      coins[i] = sc.nextInt();
    }
    System.out.println("Enter the amount");
    int amount = sc.nextInt();
    int result = waysToChange(coins, amount);
    if (result == -1) {
      System.out.println("Not possible to form the amount with given coins");
    } else {
      System.out.println("The minimum number of coins required to form the amount is : " + result);
    }
    sc.close();
  }
}
