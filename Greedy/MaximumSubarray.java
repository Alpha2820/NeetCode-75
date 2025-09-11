package Greedy;

import java.util.*;

public class MaximumSubarray {
  public static int maxSubArray(int arr[]) {
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum = sum + arr[i];
      if (sum > max) {
        max = sum;
      }
      if (sum < 0) {
        sum = 0;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of array");
    int n = sc.nextInt();
    int arr[] = new int[n];
    System.out.println("Enter the elements of array");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int result = maxSubArray(arr);
    System.out.println("The maximum subarray sum is " + result);
    sc.close();
  }
}
