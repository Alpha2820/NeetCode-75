
import java.util.*;

public class SearchInRotatedSortedArray {

  public static int search(int arr[], int target) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] == target) {
        return mid;
      }
      if (arr[low] <= arr[mid]) {
        if (target > arr[mid] || target < arr[low]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      } else {
        if (target < arr[mid] || target > arr[high]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
    }
    return -1;
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
    System.out.println("Enter the target element");
    int target = sc.nextInt();
    int result = search(arr, target);
    if (result == -1) {
      System.out.println("Element not found");
    } else {
      System.out.println("Element found at index " + result);
    }
    sc.close();
  }

}
