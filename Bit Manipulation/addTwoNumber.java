import java.util.Scanner;

public class addTwoNumber {
  public static int add(int a, int b) {
    while (b != 0) {
      int temp = a;
      a = a ^ b;
      b = (temp & b) << 1;
    }
    return a;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter two numbers: ");
    int a = sc.nextInt();
    int b = sc.nextInt();
    System.out.println("The sum is: " + add(a, b));
    sc.close();
  }

}
