package Trees;

import java.util.*;

public class validBinarySearchTree {
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

  public static boolean Helper(TreeNode root, Long left, Long right) {
    if (root == null) {
      return false;
    }
    if ((left != null && root.val <= left) || (right != null && root.val >= right)) {
      return false;
    }
    return Helper(root.left, left, (long) root.val) && Helper(root.right, (long) root.val, right);
  }

  public static boolean isValidBST(TreeNode root) {
    return Helper(root, null, null);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter elements of binary tree in level order (space-separated, use 'null' for no node):");
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
    boolean isBST = isValidBST(root);
    System.out.println("Is the binary tree a valid BST? " + isBST);
    scanner.close();
  }
}
