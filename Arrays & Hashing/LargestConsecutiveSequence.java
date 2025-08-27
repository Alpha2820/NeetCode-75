import java.util.*;

public class LargestConsecutiveSequence {

  public static int largestConsecutiveSequnece(int arr[]) {
    int n = arr.length;
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(arr[i]);
    }
    int maxStreak = 0;
    for (int value : arr) {
      int streak = 1;
      if (set.contains(value - 1))
        continue;
      while (set.contains(value + 1)) {
        value += 1;
        streak += 1;
      }
      maxStreak = Math.max(maxStreak, streak);
    }
    return maxStreak;
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
    int result = largestConsecutiveSequnece(arr);
    System.out.println("The Length of the Largest Consecutive Sequence is : " + result);
    sc.close();
  }

}
