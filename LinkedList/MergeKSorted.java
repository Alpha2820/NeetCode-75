package LinkedList;

import java.util.*;

public class MergeKSorted {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }

  public static ListNode Merge(ListNode list1, ListNode list2) {
    if (list1 == null) {
      return list2;
    }
    if (list2 == null) {
      return list1;
    }
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        current.next = list1;
        list1 = list1.next;
      } else {
        current.next = list2;
        list2 = list2.next;
      }
      current = current.next;
    }
    if (list1 != null) {
      current.next = list1;
    } else {
      current.next = list2;
    }
    return dummy.next;
  }

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    for (int i = 1; i < lists.length; i++) {
      lists[i] = Merge(lists[i], lists[i - 1]);
    }
    return lists[lists.length - 1];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter number of linked lists:");
    int k = scanner.nextInt();
    ListNode[] lists = new ListNode[k];
    for (int i = 0; i < k; i++) {
      System.out.println("Enter elements of linked list " + (i + 1) + " (space-separated, end with -1):");
      ListNode head = null, tail = null;
      while (true) {
        int val = scanner.nextInt();
        if (val == -1)
          break;
        ListNode newNode = new ListNode(val);
        if (head == null) {
          head = newNode;
          tail = newNode;
        } else {
          tail.next = newNode;
          tail = tail.next;
        }
      }
      lists[i] = head;
    }
    MergeKSorted merger = new MergeKSorted();
    ListNode mergedHead = merger.mergeKLists(lists);
    System.out.println("Merged linked list:");
    ListNode current = mergedHead;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
    scanner.close();
  }
}
