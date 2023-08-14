import java.util.Stack;

public class Java00004 {
  public static String isValid(String input) {
      String open = "{([";
      String close = "})]";
      
      int sw = 0;
      Stack<String> lastBracket = new Stack<>();
      
      String[] list = input.split("");
      
      for (int i=0; i<list.length; i++) {        
        if (open.indexOf(list[i]) >= 0) {
            sw++;
            lastBracket.push(list[i]);
            continue;
        }

        if (close.indexOf(list[i]) >= 0) {
          if (lastBracket.size() <= 0) {
            sw = -1;
            break;
          }
          
          if (open.indexOf(lastBracket.pop()) == close.indexOf(list[i])) {
            sw--;
          } else {
            sw = -1;
            break;
          }
        }
      }

      if (sw != 0) {
        return "False";
      } else {
        return "True";
      }
  }

  public static void main(String[] args) {
    System.out.println(isValid("(]")); // False
    System.out.println(isValid("(){}[]")); // True
    System.out.println(isValid("((()))")); // True
    System.out.println(isValid("((())))")); // False
  }
}
