class Solution {
  public int solution(String[] scores) {
      int answer = 0;

      for(String score : scores) {
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
                  if (fail >= 2) break;
              }

              if(max < check) {
                max = check;
              } else if(min > check) {
                min = check;
              }

              sum += check;
          }

          if (fail >= 2) continue;
          if (pass >= 2) {
              answer++;
              continue;
          }

          int avg = (sum-max-min)/(gradeList.length-2);
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
          default :
              break;
      }

      return 0;
  }
}