package BackTracking;

import java.util.*;

public class CombinationSum {
  // Placeholder for Combination Sum implementation
  List<List<Integer>> result = new ArrayList<>();

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(candidates, target, 0, new ArrayList<>(), result);
    return result;
  }

  public static void backtrack(int arr[], int target, int index, List<Integer> path, List<List<Integer>> result) {
    if (target == 0) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int i = index; i < arr.length; i++) {
      if (arr[i] > target)
        continue;
      path.add(arr[i]);
      backtrack(arr, target - arr[i], i, path, result);
      path.remove(path.size() - 1);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter candidates (space-separated):");
    String[] candidateInputs = scanner.nextLine().split(" ");
    int[] candidates = Arrays.stream(candidateInputs).mapToInt(Integer::parseInt).toArray();
    System.out.println("Enter target:");
    int target = Integer.parseInt(scanner.nextLine());
    List<List<Integer>> combinations = combinationSum(candidates, target);
    System.out.println("Combinations that sum to " + target + ": " + combinations);
    scanner.close();
  }
}
