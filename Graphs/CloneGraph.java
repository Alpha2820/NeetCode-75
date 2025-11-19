package Graphs;

import java.util.*;

class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}

public class CloneGraph {
  // Placeholder for Clone Graph implementation
  public static Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }

    Map<Node, Node> map = new HashMap<>();
    return cloneDFS(node, map);
  }

  private static Node cloneDFS(Node node, Map<Node, Node> map) {
    if (map.containsKey(node)) {
      return map.get(node);
    }

    Node cloneNode = new Node(node.val);
    map.put(node, cloneNode);

    for (Node neighbor : node.neighbors) {
      cloneNode.neighbors.add(cloneDFS(neighbor, map));
    }

    return cloneNode;
  }

}
// Time Complexity: O(V + E) where V is the number of vertices and E is the
// number of edges
// Space Complexity: O(V) for the hashmap and recursion stack