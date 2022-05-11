import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Java00002 {
  public static int solution(int[] stats) {
    List<List<Integer>> teams = new ArrayList<>();

    for(int i=0; i<stats.length; i++) {
      int test = stats[i];
      
      if(teams.size() == 0) {
        List<Integer> newTeam = new ArrayList<>();
        newTeam.add(stats[i]);
        teams.add(newTeam);
        continue;
      }

      boolean isNew = true;
      for(int j=0; j<teams.size(); j++) {
        List<Integer> team = teams.get(j);
        if(team.stream().allMatch(player -> player < test)) {
          team.add(test);
          teams.set(j, team);
          isNew = false;
          break;
        }
      }

      if(isNew == true) {
        List<Integer> newTeam = new ArrayList<>();
        newTeam.add(test);
        teams.add(newTeam);
      }
    }

    System.out.println("\n팀원 구성");
    for(List<Integer> team : teams) {
      for(Integer player : team) {
        System.out.print(player+", ");
      }

      System.out.println();
    }

    return teams.size();
  }
  
  public static void main(String[] args) {
    int[] stats = {5, 3, 4, 6, 2, 1}; // [(5,6), (3,4), (2), (1)] 팀으로 4개
    System.out.println("답 : " + solution(stats));

    int[] stats2 = {6, 2, 3, 4, 1, 5}; // [6, (2,3,4,5), (1)] 팀으로 3개
    System.out.println("답 : " + solution(stats2));

    System.out.println(ZonedDateTime.ofInstant(new Date().toInstant(), ZoneId.of("UTC")).toOffsetDateTime().toString());

  }
}
