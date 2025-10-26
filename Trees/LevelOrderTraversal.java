package Trees;

import java.util.*;

public class LevelOrderTraversal {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }

    public static List<List<Integer>> LevelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      if (root == null) {
        return result;
      }
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        int levelSize = queue.size();
        List<Integer> currentLevel = new ArrayList<>();
        for (int i = 0; i < levelSize; i++) {
          TreeNode currentNode = queue.poll();
          currentLevel.add(currentNode.val);
          if (currentNode.left != null) {
            queue.add(currentNode.left);
          }
          if (currentNode.right != null) {
            queue.add(currentNode.right);
          }
        }
        result.add(currentLevel);
      }
      return result;
    }
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
    List<List<Integer>> levels = TreeNode.LevelOrder(root);
    System.out.println("Level order traversal of the binary tree:");
    for (List<Integer> level : levels) {
      System.out.println(level);
    }
    scanner.close();
  }
}
