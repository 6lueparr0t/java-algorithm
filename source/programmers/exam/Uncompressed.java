package source.programmers.exam;

import java.util.Stack;

public class Uncompressed {
    public static String solution(String compressed) {
        String answer = "";
        String[] compressedArr = compressed.split("");

        Stack<String> stack = new Stack<String>();

        int sw = 0;
        String tmp = "";
        String word = "";
        for(String s : compressedArr) {
            if(s.equals("(")) {
                sw++;
                stack.push(tmp);
                tmp = "";
                continue;
            }

            if(s.equals(")")) {
                sw--;

                String tmpN = stack.pop();
                int n = 0;
                if(!(tmpN.charAt(0) >= '0' && tmpN.charAt(0) <= '9')) {
                    return "";
                }
                n = Integer.parseInt(tmpN);

                word += tmp;
                word += word.repeat(n-1);
                tmp = "";
                continue;
            }
            
            if(sw == 0 && !(s.charAt(0) >= '0' && s.charAt(0) <= '9')) {
                answer += word + s;
                word = "";
                continue;
            }

            tmp = tmp + s;
        }

        answer += word;

        return answer;
    }
    public static void main(String[] args) {
        String answer = solution("2(2(2(c)b)a)x2(d)");
        // aabaabccaabaabcc
        System.out.println(answer);
    }
}