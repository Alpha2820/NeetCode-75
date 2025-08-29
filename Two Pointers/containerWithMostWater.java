import java.util.*;

public class containerWithMostWater {
  public static int maxArea(int arr[]) {
    int left = 0;
    int right = arr.length - 1;
    int result = 0;
    while (left < right) {
      int max = (right - left) * Math.min(arr[left], arr[right]);
      result = Math.max(result, max);
      if (arr[left] < arr[right]) {
        left++;
      } else if (arr[right] < arr[left]) {
        right--;
      } else {
        left++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the array");
    int n = sc.nextInt();
    int arr[] = new int[n];
    System.out.println("Enter the elements of the array");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int result = maxArea(arr);
    System.out.println("The Maximum Area of the Container is : " + result);
    sc.close();
  }

}
