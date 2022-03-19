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

                int n = 0;
                try {
                    n = Integer.parseInt(stack.pop());
                } catch(NumberFormatException e) {
                    return "";
                }

                if(tmp.equals("")) {
                    word = word.repeat(n);
                } else {
                    word = word + tmp.repeat(n);
                }
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
        String answer = solution("2(2(hi)3(co))abcdefu3(bo)");
        System.out.println(answer);
    }
}