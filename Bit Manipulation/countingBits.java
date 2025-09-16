import java.util.*;

public class countingBits {
  public static int Bits(int n) {
    int count = 0;
    while (n != 0) {
      if ((n & 1) == 1) {
        count++;
      }
      n = n >> 1;
    }
    return count;
  }

  public static int[] countBit(int n) {
    int dp[] = new int[n + 1];
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      dp[i] = Bits(i);
    }
    return dp;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number: ");
    int n = sc.nextInt();
    System.out.println("Number of 1 bits: " + Arrays.toString(countBit(n)));
    sc.close();
  }
}
