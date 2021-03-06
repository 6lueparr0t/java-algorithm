import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Java00003 {
  public static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(scanner.nextLine().trim()); // 송수신 기록의 수
		String[] logs = new String[n]; // 송수신 기록
		for(int i = 0 ; i < n ; i ++) {
			logs[i] = scanner.nextLine().trim();
		}
		
		int count = 1;
		String repeat = "";
		Map<Integer, Map<String, Integer>> history = new LinkedHashMap<>();
		
    int logLength = logs.length;
		for(int i = 0; i < logLength; i++) {
			Map<String, Integer> msgMap = new LinkedHashMap<>();

			if(i+1<logLength && logs[i].equals(logs[i+1])) {
				if ("".equals(repeat)) repeat = logs[i];
				count++;
			} else if(count > 1) {
				msgMap.put(repeat, count);
				history.put(i, msgMap);
				count = 1;
				repeat = "";
			} else {
        msgMap.put(logs[i], 1);
        history.put(i, msgMap);
      }
		}
		
		System.out.println(history.size());
		for (Integer msglist : history.keySet()) {

			Map<String, Integer> list = history.get(msglist);

			for (String msg : list.keySet()) {

				if(list.get(msg) > 1) {
					System.out.printf("%s (%d)\n", msg, list.get(msg));
				} else {
					System.out.println(msg);
				}
        
			}
		}
	}
}
