import java.util.*;

public class MaximumProductSubArray {
  public static int maxProduct(int nums[]) {
    int currMax = nums[0];
    int currMin = nums[0];
    int globalMax = nums[0];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        int temp = currMax;
        currMax = currMin;
        currMin = temp;
      }
      currMax = Math.max(nums[i] * currMax, nums[i]);
      currMin = Math.min(nums[i] * currMin, nums[i]);
      globalMax = Math.max(globalMax, currMax);
    }
    return globalMax;
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
    int result = maxProduct(nums);
    System.out.println("The maximum product subarray is : " + result);
    sc.close();
  }
}
