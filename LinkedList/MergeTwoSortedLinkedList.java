package LinkedList;

import java.util.*;

public class MergeTwoSortedLinkedList {
  static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        current.next = l1;
        l1 = l1.next;
      } else {
        current.next = l2;
        l2 = l2.next;
      }
      current = current.next;
    }
    if (l1 != null) {
      current.next = l1;
    } else {
      current.next = l2;
    }
    return dummy.next;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    MergeTwoSortedLinkedList merger = new MergeTwoSortedLinkedList();
    System.out.println("Enter elements of first sorted linked list (space-separated):");
    String[] list1Elements = scanner.nextLine().split(" ");
    System.out.println("Enter elements of second sorted linked list (space-separated):");
    String[] list2Elements = scanner.nextLine().split(" ");
    ListNode l1 = null, l2 = null, tail1 = null, tail2 = null;
    for (String elem : list1Elements) {
      ListNode newNode = new ListNode(Integer.parseInt(elem));
      if (l1 == null) {
        l1 = newNode;
        tail1 = newNode;
      } else {
        tail1.next = newNode;
        tail1 = tail1.next;
      }
    }
    for (String elem : list2Elements) {
      ListNode newNode = new ListNode(Integer.parseInt(elem));
      if (l2 == null) {
        l2 = newNode;
        tail2 = newNode;
      } else {
        tail2.next = newNode;
        tail2 = tail2.next;
      }
    }
    ListNode mergedList = merger.mergeTwoLists(l1, l2);
    System.out.println("Merged sorted linked list:");
    ListNode current = mergedList;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
    scanner.close();
  }
}
