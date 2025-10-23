package LinkedList;

import java.util.*;

public class ReorderList {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }

  public void reorderList(ListNode head) {
    if (head == null || head.next == null)
      return;
    // Find the middle of the list
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    // Reverse the second half
    ListNode prev = null, curr = slow, next = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    // Merge the two halves
    ListNode first = head, second = prev;
    while (second.next != null) {
      ListNode temp1 = first.next;
      ListNode temp2 = second.next;
      first.next = second;
      second.next = temp1;
      first = temp1;
      second = temp2;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ReorderList rl = new ReorderList();
    System.out.println("Enter elements of linked list (space-separated):");
    String[] elements = scanner.nextLine().split(" ");
    ListNode head = null, tail = null;
    for (String elem : elements) {
      ListNode newNode = new ListNode(Integer.parseInt(elem));
      if (head == null) {
        head = newNode;
        tail = newNode;
      } else {
        tail.next = newNode;
        tail = tail.next;
      }
    }
    rl.reorderList(head);
    System.out.println("Reordered linked list:");
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
    scanner.close();
  }
}
