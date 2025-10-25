package Trees;

import java.util.*;

public class subTreeOfAnotherTree {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }

  public static boolean isSameTree(TreeNode s, TreeNode t) {
    if (s == null && t == null) {
      return true;
    }
    if (s == null || t == null) {
      return false;
    }
    if (s.val != t.val) {
      return false;
    }
    return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
  }

  public static boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null) {
      return false;
    }
    if (isSameTree(s, t)) {
      return true;
    }
    return isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter elements of first binary tree in level order (space-separated, use 'null' for no node):");
    String[] elements1 = scanner.nextLine().split(" ");
    if (elements1.length == 0 || elements1[0].equals("null")) {
      System.out.println("First tree is empty.");
    }
    TreeNode root1 = new TreeNode(Integer.parseInt(elements1[0]));
    Queue<TreeNode> queue1 = new LinkedList<>();
    queue1.add(root1);
    int index1 = 1;
    while (!queue1.isEmpty() && index1 < elements1.length) {
      TreeNode current = queue1.poll();
      if (!elements1[index1].equals("null")) {
        current.left = new TreeNode(Integer.parseInt(elements1[index1]));
        queue1.add(current.left);
      }
      index1++;
      if (index1 < elements1.length && !elements1[index1].equals("null")) {
        current.right = new TreeNode(Integer.parseInt(elements1[index1]));
        queue1.add(current.right);
      }
      index1++;
    }
    System.out
        .println("Enter elements of second binary tree in level order (space-separated, use 'null' for no node):");
    String[] elements2 = scanner.nextLine().split(" ");
    if (elements2.length == 0 || elements2[0].equals("null")) {
      System.out.println("Second tree is empty.");
    }
    TreeNode root2 = new TreeNode(Integer.parseInt(elements2[0]));
    Queue<TreeNode> queue2 = new LinkedList<>();
    queue2.add(root2);
    int index2 = 1;
    while (!queue2.isEmpty() && index2 < elements2.length) {
      TreeNode current = queue2.poll();
      if (!elements2[index2].equals("null")) {
        current.left = new TreeNode(Integer.parseInt(elements2[index2]));
        queue2.add(current.left);
      }
      index2++;
      if (index2 < elements2.length && !elements2[index2].equals("null")) {
        current.right = new TreeNode(Integer.parseInt(elements2[index2]));
        queue2.add(current.right);
      }
      index2++;
    }
    boolean result = isSubtree(root1, root2);
    System.out.println("Is the second tree a subtree of the first tree? " + result);
    scanner.close();
  }
}
