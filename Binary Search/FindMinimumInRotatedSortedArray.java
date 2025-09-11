import java.util.*;

public class FindMinimumInRotatedSortedArray {

  public static int findMin(int arr[]) {
    int low = 0;
    int high = arr.length - 1;
    int min = Integer.MAX_VALUE;
    while (low <= high) {
      if (arr[low] <= arr[high]) {
        min = Math.min(min, arr[low]);
        break;
      }
      int mid = low + (high - low) / 2;
      min = Math.min(min, arr[mid]);
      if (arr[mid] >= arr[low]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return min;
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
    int result = findMin(arr);
    System.out.println("The minimum element in the rotated sorted array is " + result);
    sc.close();
  }

}
