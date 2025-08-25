import java.util.*;

public class validAnagram {
  HashMap<Character, Integer> map1 = new HashMap<>();
  HashMap<Character, Integer> map2 = new HashMap<>();

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    for (int i = 0; i < s.length(); i++) {
      map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
    }
    for (int i = 0; i < t.length(); i++) {
      map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
    }
    return map1.equals(map2);
  }

  public static void main(String[] args) {
    validAnagram obj = new validAnagram();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the First String");
    String s = sc.nextLine();
    System.out.println("Enter the Second String");
    String t = sc.nextLine();
    System.out.println(obj.isAnagram(s, t));
    sc.close();
  }
}
