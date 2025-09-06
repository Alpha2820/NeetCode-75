import java.util.*;

public class threeSum {
  public List<List<Integer>> ThreeSum(int arr[]) {
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == arr[i - 1] && i > 0) {
        continue;
      }
      int left = i + 1;
      int right = arr.length - 1;
      while (left < right) {
        int sum = arr[left] + arr[i] + arr[right];
        if (sum > 0) {
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          res.add(Arrays.asList(arr[i], arr[left], arr[right]));
          left++;
          right--;
          while (left < right && arr[left] == arr[left - 1]) {
            left++;
          }
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    threeSum obj = new threeSum();
    System.out.println(obj.ThreeSum(arr));
    sc.close();
  }

}
