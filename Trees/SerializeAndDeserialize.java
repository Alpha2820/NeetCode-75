package Trees;

import java.util.*;

public class SerializeAndDeserialize {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }

    public static String serialize(TreeNode root) {
      ArrayList<String> result = new ArrayList<>();
      serializeHelper(root, result);
      return String.join(",", result);
    }

    public static void serializeHelper(TreeNode node, ArrayList<String> result) {
      if (node == null) {
        result.add("null");
        return;
      }
      result.add(String.valueOf(node.val));
      serializeHelper(node.left, result);
      serializeHelper(node.right, result);
    }

    public static TreeNode deserialize(String value[], int index[]) {
      if (index[0] >= value.length || value[index[0]].equals("null")) {
        index[0]++;
        return null;
      }
      TreeNode node = new TreeNode(Integer.parseInt(value[index[0]]));
      index[0]++;
      node.left = deserialize(value, index);
      node.right = deserialize(value, index);
      return node;
    }

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter the serialized tree (comma-separated, use 'null' for no node):");
      String input = scanner.nextLine();
      String[] values = input.split(",");
      int[] index = { 0 };
      TreeNode root = deserialize(values, index);
      String serializedTree = serialize(root);
      System.out.println("Serialized Tree: " + serializedTree);
      scanner.close();
    }
  }
}
