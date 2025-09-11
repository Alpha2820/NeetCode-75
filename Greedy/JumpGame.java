package Greedy;

import java.util.*;

public class JumpGame {

  public static boolean canJump(int arr[]) {
    int goal = arr.length - 1;
    for (int i = arr.length - 2; i >= 0; i--) {
      if (i + arr[i] >= goal) {
        goal = i;
      }
      if (goal == 0) {
        return true;
      }
    }
    return false;
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
    boolean result = canJump(arr);
    if (result) {
      System.out.println("You can reach the last index");
    } else {
      System.out.println("You cannot reach the last index");
    }
    sc.close();
  }

}
