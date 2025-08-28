import java.util.*;

public class encodeAndDecode {

  public static String encode(String str[]) {
    StringBuilder sb = new StringBuilder();
    for (String s : str) {
      sb.append(s.length()).append('#').append(s);
    }
    return sb.toString();
  }

  public static List<String> decode(String str) {
    List<String> result = new ArrayList<>();
    int i = 0;
    while (i < str.length()) {
      int j = i;
      while (str.charAt(j) != '#') {
        j++;
      }
      i = j + 1;
      int length = Integer.parseInt(str.substring(i, j));
      j = i + length;
      result.add(str.substring(i, j));
      i = j;
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the Size of the Array");
    int size = sc.nextInt();
    String str[] = new String[size];
    System.out.println("Enter the Elements of the Array");
    for (int i = 0; i < str.length; i++) {
      str[i] = sc.next();
    }
    String encodedString = encode(str);
    System.out.println("The Encoded String is : " + encodedString);
    List<String> decodedString = decode(encodedString);
    System.out.println("The Decoded Strings are : " + decodedString);
    sc.close();
  }

}
