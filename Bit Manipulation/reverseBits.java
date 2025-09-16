import java.util.*;

public class reverseBits {
  public static int reverse(int n) {
    int rev = 0;
    for (int i = 0; i < 32; i++) {
      int bit = (n >> i) & 1;
      rev = rev | (bit << (31 - i));
    }
    return rev;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number: ");
    int n = sc.nextInt();
    System.out.println("The reversed bits is: " + reverse(n));
    sc.close();
  }
}
