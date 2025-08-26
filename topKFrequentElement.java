import java.util.*;

public class topKFrequentElement {
  public static int[] TopKFrequent(int arr[], int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }
    PriorityQueue<Integer> pq = new PriorityQueue((a, b) -> map.get(b) - map.get(a));
    for (int key : map.keySet()) {
      pq.add(key);
    }
    int result[] = new int[k];
    for (int i = 0; i < arr.length; i++) {
      result[i] = pq.poll();
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
    System.out.println("Enter the value of k");
    int k = sc.nextInt();
    int result[] = TopKFrequent(arr, k);
    System.out.println("The Top K Frequent Elements are : " + Arrays.toString(result));
    sc.close();
  }
}
