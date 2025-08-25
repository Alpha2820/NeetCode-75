import java.util.*;

public class twoSum {
  public int[] TwoSum(int arr[], int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int value = target - arr[i];
      if (map.containsKey(value)) {
        return new int[] { i, map.get(value) };
      }
      map.put(arr[i], i);
    }
    return new int[] { -1, -1 };
  }

  public static void main(String[] args) {
    twoSum obj = new twoSum();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the Size of the Array");
    int size = sc.nextInt();
    int arr[] = new int[size];
    System.out.println("Enter the Elements of the Array");
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println("Enter the Target");
    int target = sc.nextInt();
    int result[] = obj.TwoSum(arr, target);
    System.out.println("The Indices are : " + Arrays.toString(result));
    sc.close();
  }

}
