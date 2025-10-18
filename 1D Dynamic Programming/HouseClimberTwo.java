import java.util.*;

public class HouseClimberTwo {
  public static int helper(int arr[]) {
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

  public int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int arr1[] = new int[nums.length - 1];
    int arr2[] = new int[nums.length - 1];
    for (int i = 0; i < nums.length - 1; i++) {
      arr1[i] = nums[i];
      arr2[i] = nums[i + 1];
    }
    return Math.max(helper(arr1), helper(arr2));
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
    HouseClimberTwo obj = new HouseClimberTwo();
    int result = obj.rob(arr);
    System.out.println("The maximum amount of money that can be robbed is : " + result);
    sc.close();
  }

}
