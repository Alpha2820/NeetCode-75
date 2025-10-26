package Trees;

import java.util.*;

public class LowestCommonAncestor {
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

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == null || q == null) {
      return null;
    }
    int max = Math.max(p.val, q.val);
    int min = Math.min(p.val, q.val);
    if (max < root.val) {
      return lowestCommonAncestor(root.left, p, q);
    } else if (min > root.val) {
      return lowestCommonAncestor(root.right, p, q);
    } else {
      return root;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out
        .println("Enter elements of binary search tree in level order (space-separated, use 'null' for no node):");
    String[] elements = scanner.nextLine().split(" ");
    if (elements.length == 0 || elements[0].equals("null")) {
      System.out.println("The tree is empty.");
      scanner.close();
      return;
    }
    TreeNode root = new TreeNode(Integer.parseInt(elements[0]));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int index = 1;
    while (!queue.isEmpty() && index < elements.length) {
      TreeNode current = queue.poll();
      if (!elements[index].equals("null")) {
        current.left = new TreeNode(Integer.parseInt(elements[index]));
        queue.add(current.left);
      }
      index++;
      if (index < elements.length && !elements[index].equals("null")) {
        current.right = new TreeNode(Integer.parseInt(elements[index]));
        queue.add(current.right);
      }
      index++;
    }
    System.out.println("Enter value of first node:");
    int val1 = scanner.nextInt();
    System.out.println("Enter value of second node:");
    int val2 = scanner.nextInt();
    TreeNode p = new TreeNode(val1);
    TreeNode q = new TreeNode(val2);
    TreeNode lca = lowestCommonAncestor(root, p, q);
    if (lca != null) {
      System.out.println("Lowest Common Ancestor: " + lca.val);
    } else {
      System.out.println("Lowest Common Ancestor not found.");
    }
    scanner.close();
  }
}