import java.util.*;

public class validParenthesis {
  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (stack.isEmpty() && (ch == ']' || ch == '}' || ch == ')')) {
        return false;
      } else if (ch == ']' && stack.peek() == '[') {
        stack.pop();
      } else if (ch == '}' && stack.peek() == '{') {
        stack.pop();
      } else if (ch == ')' && stack.peek() == '(') {
        stack.pop();
      } else {
        stack.push(ch);
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    System.out.println(isValid(s));
    sc.close();
  }
}
