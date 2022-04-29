import java.util.Scanner;

public class SearchIndex {
  static int searchIdx(int[] x, int num, int key, int[] y) {
    int count = 0;
    for(int i=0; i<num; i++) {
      if(x[i] == key) y[count++] = i;
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

		System.out.print("count：");
		int num = scan.nextInt();
		int[] x = new int[num]; // count num인 배열
		int[] y = new int[num]; // count num인 배열

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = scan.nextInt();
		}
		System.out.print("찾는 값："); // 키 값을 입력 받음
		int key = scan.nextInt();

		int count = searchIdx(x, num, key, y);

		if (count == 0) {
			System.out.println("그 값의 요소가 없습니다.");
    } else {
			for (int i = 0; i < count; i++) {
				System.out.println("그 값은 " + "x[" + y[i] + "]에 있습니다.");
      }
    }

    scan.close();
  }
}
