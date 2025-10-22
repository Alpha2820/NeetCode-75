package LinkedList;

import java.util.*;

public class ReverseLinkedList {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }

  public static ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    while (current != null) {
      ListNode nextTemp = current.next;
      current.next = prev;
      prev = current;
      current = nextTemp;
    }
    return prev;
  }

  public static void printList(ListNode head) {
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val + " -> ");
      current = current.next;
    }
    System.out.println("null");
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of nodes in the linked list:");
    int n = sc.nextInt();
    ListNode head = null;
    ListNode tail = null;

    System.out.println("Enter the node values:");
    for (int i = 0; i < n; i++) {
      int val = sc.nextInt();
      ListNode newNode = new ListNode(val);
      if (head == null) {
        head = newNode;
        tail = newNode;
      } else {
        tail.next = newNode;
        tail = newNode;
      }
    }

    System.out.println("Original Linked List:");
    printList(head);

    head = reverseList(head);

    System.out.println("Reversed Linked List:");
    printList(head);
    sc.close();
  }
}
