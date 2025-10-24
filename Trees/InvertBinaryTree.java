package Trees;

import java.util.*;

public class InvertBinaryTree {
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

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode node = new TreeNode(root.val);
    node.right = invertTree(root.left);
    node.left = invertTree(root.right);
    return node;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    InvertBinaryTree inverter = new InvertBinaryTree();
    System.out.println("Enter elements of binary tree in level order (space-separated, use 'null' for no node):");
    String[] elements = scanner.nextLine().split(" ");
    if (elements.length == 0 || elements[0].equals("null")) {
      System.out.println("Inverted tree is empty.");
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
    TreeNode invertedRoot = inverter.invertTree(root);
    System.out.println("Inverted binary tree in level order:");
    queue.clear();
    queue.add(invertedRoot);
    while (!queue.isEmpty()) {
      TreeNode current = queue.poll();
      if (current != null) {
        System.out.print(current.val + " ");
        queue.add(current.left);
        queue.add(current.right);
      } else {
        System.out.print("null ");
      }
    }
    scanner.close();
  }
}
