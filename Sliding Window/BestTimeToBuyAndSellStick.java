import java.util.*;

public class BestTimeToBuyAndSellStick {
  public static int maxProfit(int arr[]) {
    int left = 0;
    int right = 1;
    int maxProfit = 0;
    while (right < arr.length) {
      if (arr[left] < arr[right]) {
        maxProfit = Math.max(maxProfit, arr[right] - arr[left]);
      } else {
        left = right;
      }
      right++;
    }
    return maxProfit;
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
    System.out.println("The maximum profit is " + maxProfit(arr));
    sc.close();
  }

}
