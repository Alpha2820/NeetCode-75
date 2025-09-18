package Intervals;

import java.util.*;

public class NonOverlaping {
  public int eraseOverlapIntervals(int arr[][]) {
    Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
    int result = 0;
    int previous = arr[0][1];
    ;
    for (int i = 1; i < arr.length; i++) {
      int start = arr[i][0];
      int end = arr[i][1];
      if (start < previous) {
        result++;
      } else {
        previous = end;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    NonOverlaping obj = new NonOverlaping();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of intervals");
    int n = sc.nextInt();
    int arr[][] = new int[n][2];
    System.out.println("Enter the intervals");
    for (int i = 0; i < n; i++) {
      arr[i][0] = sc.nextInt();
      arr[i][1] = sc.nextInt();
    }
    System.out.println("The number of intervals to be removed are : " + obj.eraseOverlapIntervals(arr));
    sc.close();
  }
}
