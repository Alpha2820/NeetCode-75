package LinkedList;

import java.util.*;

public class LinkedListCycle {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }

  public boolean hasCycle(ListNode head) {
    if (head == null)
      return false;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast)
        return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    LinkedListCycle llc = new LinkedListCycle();
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
    System.out.println("Does the linked list have a cycle? " + llc.hasCycle(head));
    scanner.close();
  }
}
