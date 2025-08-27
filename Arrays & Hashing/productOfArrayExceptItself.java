import java.util.Scanner;

public class productOfArrayExceptItself {
  public static int[] ProductOfArrayExceptItself(int arr[]) {
    int n = arr.length;
    int result[] = new int[n];
    int prefix = 1;
    for (int i = 0; i < n; i++) {
      result[i] = prefix;
      prefix *= arr[i];
    }
    int postfix = 1;
    for (int i = n - 1; i >= 0; i--) {
      result[i] *= postfix;
      postfix *= arr[i];
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the Size of the Array");
    int size = sc.nextInt();
    int arr[] = new int[size];
    System.out.println("Enter the Elements of the Array");
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }
    int result[] = ProductOfArrayExceptItself(arr);
    System.out.println("The Product of Array Except Itself is : ");
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + " ");
    }
    sc.close();
  }

}
