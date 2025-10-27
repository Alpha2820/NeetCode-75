package Trees;

import java.util.*;

public class kthSmallestIntegerBST {
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

  public static void Helper(TreeNode root, ArrayList<Integer> arr) {
    if (root == null) {
      return;
    }
    Helper(root.left, arr);
    arr.add(root.val);
    Helper(root.right, arr);
  }

  public static int kthSmallest(TreeNode root, int k) {
    ArrayList<Integer> arr = new ArrayList<>();
    Helper(root, arr);
    return arr.get(k - 1);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter elements of BST in level order (space-separated, use 'null' for no node):");
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
    System.out.println("Enter the value of k:");
    int k = scanner.nextInt();
    int result = kthSmallest(root, k);
    System.out.println("The " + k + "th smallest element in the BST is: " + result);
    scanner.close();
  }
}
