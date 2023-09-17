
// 짝 짓기 (baabaa -> baba -> 종료 1)
import java.util.Stack;

public class Java00006 {
  public int solution(String s) {
    Stack<Character> stack = new Stack<>();

    char[] list = s.toCharArray();

    for (char c : list) {
      if (stack.size() > 0 && stack.peek() == c) {
        stack.pop();
      } else {
        stack.push(c);
      }
    }

    if (stack.size() > 0) {
      return 0;
    } else {
      return 1;
    }
  }
}