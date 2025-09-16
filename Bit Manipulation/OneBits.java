import java.util.*;

public class OneBits {
  public static int countBit(int n) {
    int count = 0;
    while (n != 0) {
      if ((n & 1) == 1) {
        count++;
      }
      n = n >> 1;
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number: ");
    int n = sc.nextInt();
    System.out.println("Number of 1 bits: " + countBit(n));
    sc.close();
  }

}
