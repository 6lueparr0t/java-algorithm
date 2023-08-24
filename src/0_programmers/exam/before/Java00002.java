// 팀매칭하기 : 플레이어가 게임 대기실에 들어온 순서와 플레이어의 등급에 따라 팀을 자동으로 편성함
// - 먼저 들어온 플레이어의 팀을 먼저 정함
// - 새로 들어온 플레이어는 새 팀에 배정하거나, 혹은 모든 팀원의 등급이 해당하는 플레어의 등급보다 낮은 팀에만 배정할 수 있음
// (숫자가 작을 수록 낮은 등급)

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java00002 {
  public static int solution(int[] stats) {
    Map<Integer, List<Integer>> teams = new HashMap<>();

    int teamCount = 0;
    boolean isNew = true;
    for(int i=0; i<stats.length; i++) {
      int test = stats[i];

      isNew = true;
      for(Map.Entry<Integer, List<Integer>> tmpTeams : teams.entrySet()) {
        List<Integer> team = tmpTeams.getValue();
        if(team.get(0) < test) {
          team.add(test);
          Collections.sort(team, Collections.reverseOrder());
          teams.put(tmpTeams.getKey(), team);
          isNew = false;
          break;
        }
      }

      if(isNew == true) {
        List<Integer> newTeam = new ArrayList<>();
        newTeam.add(test);
        teams.put(teamCount++, newTeam);
      }
    }

    System.out.println("\n팀원 구성");
    for(Map.Entry<Integer, List<Integer>> team : teams.entrySet()) {
      for(Integer player : team.getValue()) {
        System.out.print(player+", ");
      }

      System.out.println();
    }

    return teamCount;
  }
  
  public static void main(String[] args) {
    int[] stats = {5, 3, 4, 6, 2, 1}; // [(5,6), (3,4), (2), (1)] 팀으로 4개
    System.out.println("답 : " + solution(stats));

    int[] stats2 = {6, 2, 3, 4, 1, 5}; // [6, (2,3,4,5), (1)] 팀으로 3개
    System.out.println("답 : " + solution(stats2));

    System.out.println(ZonedDateTime.ofInstant(new Date().toInstant(), ZoneId.of("UTC")).toOffsetDateTime().toString());

  }
}
