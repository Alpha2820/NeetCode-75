import java.util.*;

public class groupAnagram {

  public List<List<String>> GroupAnagram(String str[]) {
    HashMap<String, ArrayList<String>> map = new HashMap<>();
    for (String s : str) {
      char ch[] = s.toCharArray();
      Arrays.sort(ch);
      String key = new String(ch);
      map.putIfAbsent(key, new ArrayList<>());
      map.get(key).add(s);
    }
    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    groupAnagram obj = new groupAnagram();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the Size of the Array");
    int size = sc.nextInt();
    String str[] = new String[size];
    System.out.println("Enter the Elements of the Array");
    for (int i = 0; i < str.length; i++) {
      str[i] = sc.next();
    }
    List<List<String>> result = obj.GroupAnagram(str);
    System.out.println("The Grouped Anagrams are : " + result);
    sc.close();
  }
}
