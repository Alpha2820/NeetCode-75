package Heap;

import java.util.*;

public class FindMedianInDataStream {
  public static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  public static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

  public static Double findMedian() {
    if (maxHeap.size() > minHeap.size()) {
      return (double) maxHeap.peek();
    } else if (maxHeap.isEmpty()) {
      return 0.0;
    } else {
      return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
  }

  public static void addNum(int num) {
    if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
      maxHeap.offer(num);
    } else {
      minHeap.offer(num);
    }
    if (maxHeap.size() > minHeap.size() + 1) {
      minHeap.offer(maxHeap.poll());
    } else if (minHeap.size() > maxHeap.size()) {
      maxHeap.offer(minHeap.poll());
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter numbers to add to the data stream (space-separated):");
    String[] inputs = scanner.nextLine().split(" ");
    for (String input : inputs) {
      int num = Integer.parseInt(input);
      addNum(num);
      System.out.println("Current Median: " + findMedian());
    }
    scanner.close();
  }
}
