import java.util.*;

public class LongestIncreasingSubsequence {
  public static int lengthLIS(int nums[]) {
    int dp[] = new int[nums.length];
    Arrays.fill(dp, 1);
    int maxLength = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] > nums[i]) {
          dp[i] = Math.max(dp[i], 1 + dp[j]);
          maxLength = Math.max(maxLength, dp[i]);
        }
      }
    }
    return maxLength;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements in the array");
    int n = sc.nextInt();
    int nums[] = new int[n];
    System.out.println("Enter the elements of the array");
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    int result = lengthLIS(nums);
    System.out.println("The length of longest increasing subsequence is : " + result);
    sc.close();
  }
}
