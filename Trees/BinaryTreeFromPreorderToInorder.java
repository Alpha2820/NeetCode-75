package Trees;

import java.util.*;

public class BinaryTreeFromPreorderToInorder {
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

  public static TreeNode buildTree(int pre[], int in[]) {
    if (pre.length == 0 || in.length == 0) {
      return null;
    }
    TreeNode root = new TreeNode(pre[0]);
    int rootIndexInInorder = -1;
    for (int i = 0; i < in.length; i++) {
      if (in[i] == pre[0]) {
        rootIndexInInorder = i;
        break;
      }
    }
    int leftPreOrder[] = Arrays.copyOfRange(pre, 1, rootIndexInInorder + 1);
    int rightPreOrder[] = Arrays.copyOfRange(pre, rootIndexInInorder + 1, pre.length);
    int leftInOrder[] = Arrays.copyOfRange(in, 0, rootIndexInInorder);
    int rightInOrder[] = Arrays.copyOfRange(in, rootIndexInInorder + 1, in.length);
    root.left = buildTree(leftPreOrder, leftInOrder);
    root.right = buildTree(rightPreOrder, rightInOrder);
    return root;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter elements of preorder traversal (space-separated):");
    String[] preElements = scanner.nextLine().split(" ");
    System.out.println("Enter elements of inorder traversal (space-separated):");
    String[] inElements = scanner.nextLine().split(" ");
    int[] pre = new int[preElements.length];
    int[] in = new int[inElements.length];
    for (int i = 0; i < preElements.length; i++) {
      pre[i] = Integer.parseInt(preElements[i]);
    }
    for (int i = 0; i < inElements.length; i++) {
      in[i] = Integer.parseInt(inElements[i]);
    }
    TreeNode root = buildTree(pre, in);
    System.out.println("Binary Tree constructed from Preorder and Inorder traversals." + root);
    scanner.close();
  }
}
