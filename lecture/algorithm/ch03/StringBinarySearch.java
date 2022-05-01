import java.util.Arrays;
import java.util.Scanner;

public class StringBinarySearch {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // Java에서 사용하는 키워드입니다.
    String[] x = {
        "abstract", "assert", "boolean", "break", "byte",
        "case", "catch", "char", "class", "const",
        "continue", "default", "do", "double", "else",
        "enum", "extends", "final", "finally", "float",
        "for", "goto", "if", "implements", "import",
        "instanceof", "int", "interface", "long", "native",
        "new", "package", "private", "protected", "public",
        "return", "short", "static", "strictfp", "super",
        "switch", "synchronized", "this", "throw", "throws",
        "transient", "try", "void", "volatile", "while"
    };

    System.out.print("원하는 키워드를 입력하세요. : ");
    String key = scan.next();

    int idx = Arrays.binarySearch(x, key);

    if (idx < 0) {
      System.out.printf("해당 값이 없습니다. 삽입 포인트 : %d\n", -idx-1);
    } else {
      System.out.printf("해당 키워드는 x[%d] 에 있습니다.\n", idx);
    }

    scan.close();
  }
}
