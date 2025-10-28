package Trees;

import java.util.*;

public class BinaryTreeMaximumPathSum {
  static int result = Integer.MIN_VALUE;

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

  public static int getMax(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int leftMax = Math.max(0, getMax(node.left));
    int rightMax = Math.max(0, getMax(node.right));
    result = Math.max(result, leftMax + rightMax + node.val);
    return Math.max(leftMax, rightMax) + node.val;
  }

  public static void dfs(TreeNode node) {
    if (node == null) {
      return;
    }
    int left = getMax(node.left);
    int right = getMax(node.right);
    result = Math.max(result, left + right + node.val);
    dfs(node.left);
    dfs(node.right);
  }

  public int maxPathSum(TreeNode root) {
    getMax(root);
    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter elements of the binary tree in level order (space-separated, use 'null' for no node):");
    String[] elements = scanner.nextLine().split(" ");
    if (elements.length == 0 || elements[0].equals("null")) {
      System.out.println("Maximum Path Sum: 0");
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
    BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();
    int maxPathSum = solution.maxPathSum(root);
    System.out.println("Maximum Path Sum: " + maxPathSum);
    scanner.close();
  }
}
