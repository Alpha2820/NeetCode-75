import java.util.Scanner;

public class MissingNumber {
  public static int missNumber(int[] arr) {
    int missing = arr.length;
    for (int i = 0; i < arr.length; i++) {
      missing ^= i ^ arr[i];
    }
    return missing;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of array: ");
    int n = sc.nextInt();
    int arr[] = new int[n];
    System.out.println("Enter the elements of array: ");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println("The missing number is: " + missNumber(arr));
    sc.close();
  }

}
