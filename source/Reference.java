package source;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Reference {
    public static void main(String[] args) {
        Reference test = new Reference();

//        int[] s2_1 = {1,2,3,6};
//        System.out.println(Arrays.stream(test.solution2(s2_1, 3)).boxed().collect(Collectors.toList()));

//        System.out.println(test.solution4(10, 85, 30));
//        System.out.println(test.solution4(5, 105, 3));

//        int[] s5_1 = {1, 2, 3, 5};
//        System.out.println(test.solution5(s5_1));

//        int[] s6_1 = {3, 1, 2, 4, 3};
//        System.out.println(test.solution6(s6_1));

//        int[] s7_1 = {1, 3, 1, 4, 2, 3, 5, 4};
//        System.out.println(test.solution7(5, s7_1));

//        int[] s8_1 = {1,2,3};
//        System.out.println(test.solution8(s8_1));
//
//        int[] s8_2 = {1,2,4};
//        System.out.println(test.solution8(s8_2));

//        long start = System.currentTimeMillis();
//
//        System.out.println(test.solution9(""));
//
//        long end = System.currentTimeMillis();
//        System.out.println( "실행 시간 : " + ( end - start )/1000.00 + "초");

//        long start = System.currentTimeMillis();
//
//        int[] A = {3,2,4,3};
//        System.out.println(Arrays.stream(test.solution10(A,2,4)).boxed().collect(Collectors.toList()));
//
//        long end = System.currentTimeMillis();
//        System.out.println( "실행 시간 : " + ( end - start )/1000.00 + "초");

//        long start = System.currentTimeMillis();

//        int[] a = {1,3,2,1,2,1,5,3,3,4,2}; //expect 9
//        System.out.println(test.solution13(a));

//        long end = System.currentTimeMillis();
//        System.out.println( "실행 시간 : " + ( end - start )/1000.00 + "초");

        //최대값 구하기
//        int[] tab = {12, 1, 21, 8};
//        IntSummaryStatistics stat = Arrays.stream(tab).summaryStatistics();
//        int min = stat.getMin();
//        int max = stat.getMax();
//        System.out.println("Min = " + min);
//        System.out.println("Max = " + max);

        System.out.println(test.solution14("John Doe, James Doe, Jane Doe", "Example"));
    }

    int solution15(int[] A) {
        // write your code in Java SE 8
        if (A.length <= 2) {
            return 1;
        } else {
            int result = 2;
            int tmp = 2;

            for (int k = 2; k < A.length; ++k) {
                if (A[k] == A[k-2]) {
                    tmp = tmp + 1;
                } else {
                    tmp = 2;
                }

                result = Math.max(result, tmp);

            }

            return result;
        }
    }

    String solution14(String S, String C) {
        // write your code in Java SE 8
        String[] NameArray = S.split(", ");
        String company = C.toLowerCase();

        Set<String> mailSet = new HashSet<String>();
        List<String> mailComplete = new ArrayList<>();
        String mail = "";

        for(String nameStr : NameArray) {
            String[] nameDivied = nameStr.replace("-", "").split(" ");

            for(int i = 0; i < NameArray.length; i++ ) {
                String num = ((i == 0)?"":Integer.toString(i+1));

                int nameDiviedSize = nameDivied.length - 1;
                if (nameDivied[nameDiviedSize].length() > 8) {
                    nameDivied[nameDiviedSize] = nameDivied[nameDiviedSize].substring(0, 8);
                }

                if (nameDivied.length <= 2) {
                    mail = nameDivied[0].toLowerCase().substring(0,1)+ nameDivied[1].toLowerCase() + num + "@" + company + ".com";
                } else if (nameDivied.length == 3) {
                    mail = nameDivied[0].toLowerCase().substring(0,1) + nameDivied[1].toLowerCase().substring(0,1) + nameDivied[2].toLowerCase() + num + "@" + company + ".com";
                }

                if (!mailSet.contains(mail)) {
                    break;
                }
            }

            mailSet.add(mail);
            mailComplete.add(nameStr+" <"+mail+">");
        }

        return String.join(", ", mailComplete);
    }

    int solution13(int[] A) {
        // write your code in Java SE 8
        int count = 0;

        int max = A[0];

        for (int i = 1; i < A.length; i++)
            if (A[i] > max) max = A[i];

        int[] sw = new int[max];

        for (int i = 0; i < max; i++) {
            sw[i] = 0;
            for (int j = 0; j < A.length; j++) {
                // 현재높이 A[j], 탐색 값(i+1)
                if (A[j] < (i+1)) {
                    if ((j+1) < A.length && A[j + 1] >= (i + 1)) {
                        sw[i]++;
                    }
                }
            }

            if(sw[i] == 0) {
                sw[i] = 1;
            }
        }

        for (int k : sw) {
            count += k;
        }

        return count;
    }

    /**
     * 비어있는 양의 정수 가져오기
     * ex1) [1,2,4,5,6] -> 3이 중간에 없음 -> 출력 3
     * ex1) [1,2,3] -> 출력 4
     * ex2) [-1, -3] -> 양의 정수가 없음 -> 출력 1
     *
     * @param N
     * @return
     */
    int solution0(int[] N) {
        Set<Integer> set = new HashSet<>();

        for (int s : N) {
            set.add(s);
        }

        for (int i = 1; true; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
    }

    /**
     * 숫자를 Binary 로 바꾸고, 그 안에 갭(gap)을 세는 함수
     * ex) 33 입력 시 -> 100001 -> 0000 -> 4 출력
     *
     * @param N
     * @return totalGapLength
     */
    int solution1(int N) {
        String binaryString = Integer.toBinaryString(N);
        char[] binaryChar = binaryString.toCharArray();

        int totalGapLength = 0;
        int gap = 0;

        for (char c : binaryChar) {
            if (c == '1') {
                if (gap > totalGapLength) {
                    totalGapLength = gap;
                }
                gap = 0;
            } else {
                ++gap;
            }
        }

        return totalGapLength;
    }

    int[] solution2(int[] A, int K) {
        int arraySize = A.length;

        int[] shiftedArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            shiftedArray[(i + K) % arraySize] = A[i];
        }

        return shiftedArray;
    }

    int solution3(int[] A) {
        int result = 0;

        for (int i : A) {
            result ^= i;
        }
        return result;
    }

    // --------------------------------------------------

    int solution4(int X, int Y, int D) {
        int distance = Y - X;
        int answer = distance / D;

        return ((distance % D) == 0) ? answer : answer + 1;
    }

    int solution5(int[] A) {
        Arrays.sort(A);

        if (A.length == 0) {
            return 1;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return A.length + 1;
    }

    int solution6(int[] A) {
        //{3, 1, 2, 4, 3};
        int N = A.length;

        int sum1 = A[0];
        int sum2 = 0;

        for (int i = 1; i < N; i++) {
            sum2 += A[i];
        }
        int diff = Math.abs(sum1 - sum2);

        for (int i = 1; i < N - 1; i++) {
            sum1 += A[i];
            sum2 -= A[i];

            int newDiff = Math.abs(sum1 - sum2);
            if (newDiff < diff) {
                diff = newDiff;
            }
        }
        return diff;
    }

    /**
     *   A[0] = 1
     *   A[1] = 3
     *   A[2] = 1
     *   A[3] = 4
     *   A[4] = 2
     *   A[5] = 3
     *   A[6] = 5
     *   A[7] = 4
     *
     *   return 6;
     * @param X
     * @param A
     * @return
     */
    int solution7(int X, int[] A) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i <= A.length; i++) {
            if(A[i] <= X) set.add(A[i]);
            if(set.size() == X) return i;
        }

        return -1;
    }

    int solution8(int[] A) {
        Arrays.sort(A);

        Set<Integer> set = new HashSet<>();
        for(int i : A) {
            set.add(i);
        }

        List<Integer> list = new ArrayList<>(set);

        if (A.length != list.size() || list.get(0) != 1 || list.get(list.size() - 1) != A.length) {
            return 0;
        }

        return 1;
    }

    int solution9(String S) {

        int count = 0;
        int others = 0;

        char[] charArrays = S.toCharArray();
        for (char c : charArrays) {
            if (c == 'a') {
                count++;
            } else {
                others++;
                count = 0;
            }
            if (count == 3) {
                return -1;
            }
        }
        return 2 * (others + 1) - (charArrays.length - others);
    }

    int[] solution10(int[] A, int F, int M) {
        int sum = 0;
        for(int i : A) {
            sum += i;
        }

        int[] answer = new int[F];
        if(sum > 6 && M == 1) {
            int[] wrong = {0};
            return wrong;
        }

        int other = M * (A.length + F) - sum;

        for (int i = 0; i < F; i++) {
            if(other / 6 >= 1) {
                answer[i] = 6;
                other -= 6;
            } else {
                answer[i] = 1;
                other -= 1;
            }
        }

        if(other > 0) {
            int[] wrong = {0};
            return wrong;
        }

        return answer;
    }

    int solution11(String S) {
        int loc = 0;
        int cur = 0;
        int end = 0;
        for(int i=0; i < S.length() - 1; i++) {
            for(int j=2; j <= S.length() - 1; j++) {
                end = Math.min(i + j, S.length());
                String test = S.substring(i, end);
                cur = S.lastIndexOf(test);
                if(loc <= (cur-i)) {
                    loc = cur-i;
                }
            }
        }
        return loc;
    }

    // 백준 기본 문제
    void solution12() {
        Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println(a + b);
    }
/*
    // 소스 실행전 시간 취득
    long start = System.currentTimeMillis();

    //실행시간을 측정하고싶은 코드 작성

    // 소스 실행후 시간 취득
    long end = System.currentTimeMillis();

    // 측정 시간 출력
    System.out.println( "실행 시간 : " + ( end - start )/1000.0 +”초”);
*/
}
