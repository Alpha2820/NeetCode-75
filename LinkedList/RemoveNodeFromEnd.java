package LinkedList;

import java.util.*;

public class RemoveNodeFromEnd {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode current = head;
    if (current == null) {
      return null;
    }
    int count = 0;
    while (current != null) {
      count++;
      current = current.next;
    }
    int rem = count - n;
    if (rem == 0) {
      return head.next;
    }
    current = head;
    for (int i = 1; i < rem; i++) {
      current = current.next;
    }
    current.next = current.next.next;
    return head;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    RemoveNodeFromEnd remover = new RemoveNodeFromEnd();
    System.out.println("Enter elements of linked list (space-separated):");
    String[] elements = scanner.nextLine().split(" ");
    System.out.println("Enter the value of n:");
    int n = scanner.nextInt();
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
    head = remover.removeNthFromEnd(head, n);
    System.out.println("Linked list after removing " + n + "th node from end:");
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
    scanner.close();
  }
}
