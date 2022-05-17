import java.util.Stack;

public class Java00002 {
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
            sw--;
            break;
          }
          
          if (open.indexOf(lastBracket.pop()) == close.indexOf(list[i])) sw--;
        }
      }

      if (sw != 0) {
        return "false";
      } else {
        return "true";
      }
  }

  public static void main(String[] args) {
    System.out.println(isValid("(]"));
    System.out.println(isValid("(){}[]"));
    System.out.println(isValid("((()))"));
    System.out.println(isValid("((())))"));
  }
}
