package tutorial;
// https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
// import java.util.*;

public class lesson1_binaryGap {
  public static int solution(int N) {
    char[] binary = Integer.toBinaryString(N).toCharArray();

    int result = 0;
    int count = 0;
    for (char c : binary) {
        if (c == '0') {
            count++;
        } else {
            result = (result <= count)? count : result;
            count = 0;
        }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(solution(1041));

    System.out.println(solution(15));

    System.out.println(solution(32));
  }
}
