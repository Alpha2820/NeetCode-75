package Intervals;

import java.util.*;

public class MergeInterval {
  public int[][] merge(int arr[][]) {
    Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
    List<int[]> result = new ArrayList<>();
    result.add(arr[0]);
    for (int i = 1; i < arr.length; i++) {
      int start = arr[i][0];
      int end = arr[i][1];
      int[] lastInterval = result.get(result.size() - 1);
      if (start <= lastInterval[1]) {
        lastInterval[1] = Math.max(lastInterval[1], end);
      } else {
        result.add(arr[i]);
      }
    }
    return result.toArray(new int[result.size()][]);
  }

  public static void main(String[] args) {
    MergeInterval obj = new MergeInterval();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of intervals");
    int n = sc.nextInt();
    int arr[][] = new int[n][2];
    System.out.println("Enter the intervals");
    for (int i = 0; i < n; i++) {
      arr[i][0] = sc.nextInt();
      arr[i][1] = sc.nextInt();
    }
    int result[][] = obj.merge(arr);
    System.out.println("The merged intervals are : ");
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i][0] + " " + result[i][1]);
    }
    sc.close();
  }

}
