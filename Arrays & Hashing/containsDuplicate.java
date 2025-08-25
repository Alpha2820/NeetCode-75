import java.util.*;

public class containsDuplicate {
  public boolean ContainsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.contains(num)) {
        return true;
      }
      set.add(num);
    }
    return false;
  }

  public static void main(String[] args) {
    containsDuplicate obj = new containsDuplicate();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the Size of the Array");
    int size = sc.nextInt();
    int arr[] = new int[size];
    System.out.println("Enter the Elements of the Array");
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(obj.ContainsDuplicate(arr));
    sc.close();
  }
}
