import java.util.*;

public class HouseRobber {
  public static int robber(int arr[]) {
    int n = arr.length;
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return arr[0];
    }
    int dp[] = new int[n + 1];
    dp[1] = arr[0];
    dp[2] = Math.max(arr[0], arr[1]);
    for (int i = 3; i <= n; i++) {
      dp[i] = Math.max(dp[i - 1], arr[i - 1] + dp[i - 2]);
    }
    return dp[arr.length];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of houses");
    int n = sc.nextInt();
    int arr[] = new int[n];
    System.out.println("Enter the amount of money in each house");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int result = robber(arr);
    System.out.println("The maximum amount of money that can be robbed is : " + result);
    sc.close();
  }

}
