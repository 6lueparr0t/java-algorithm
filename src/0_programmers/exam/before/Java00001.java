// 등급 매기기
// - scores 는 {"ABCDEF", "AABBCC", "AAFFF" ...} 이런 식으로 되어있음
// - 등급의 순서는 다음과 같다.
// -- F가 두개인 경우엔 그냥 탈락
// -- AA 가 두개인 경우 패스
// -- 등급별 점수를 매겨 최고 점수와 최하 점수를 뺀 평균이 3점 이상인 경우 합격
//
// 그래서 합격한 학생의 수를 구함

class Solution {
  public int solution(String[] scores) {
    int answer = 0;

    for (String score : scores) {
      char[] gradeList = score.toCharArray();

      int pass = 0;
      int fail = 0;

      int sum = 0;
      int max = 0;
      int min = 6;

      for (char grade : gradeList) {
        int check = getScore(grade);
        if (check >= 5) {
          pass++;
        } else if (check == 0) {
          fail++;
          if (fail >= 2)
            break;
        }

        if (max < check) {
          max = check;
        } else if (min > check) {
          min = check;
        }

        sum += check;
      }

      if (fail >= 2)
        continue;
      if (pass >= 2) {
        answer++;
        continue;
      }

      int avg = (sum - max - min) / (gradeList.length - 2);
      if (avg >= 3) {
        answer++;
      }
    }

    return answer;
  }

  public static int getScore(char grade) {
    switch (grade) {
      case 'A':
        return 5;
      case 'B':
        return 4;
      case 'C':
        return 3;
      case 'D':
        return 2;
      case 'E':
        return 1;
      case 'F':
        break;
      default:
        break;
    }

    return 0;
  }
}