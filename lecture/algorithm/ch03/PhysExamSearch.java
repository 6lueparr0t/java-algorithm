import java.util.Arrays;
import java.util.Comparator;
// 신체검사 데이터 배열에서 이진 검색하기
import java.util.Scanner;

class PhysExamSearch {
  // 신체검사 데이터를 정의합니다.
  static class PhyscData {
    private String name; // 이름
    private int height; // 키
    private double vision; // 시력

    // 생성자
    public PhyscData(String name, int height, double vision) {
      this.name = name;
      this.height = height;
      this.vision = vision;
    }

    // 문자열을 반환하는 메서드(정보 확인용)
    public String toString() {
      return name + " " + height + " " + vision;
    }

    public double getVision() {
      return this.vision;
    }

    // 내림차순으로 정렬하기 위한 comparator
    public static final Comparator<PhyscData> VISION_ORDER = new VisionOrderComparator();

    private static class VisionOrderComparator implements Comparator<PhyscData> {
      public int compare(PhyscData d1, PhyscData d2) {
        return (d1.vision < d2.vision) ? 1 : (d1.vision > d2.vision) ? -1 : 0;
      }
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    PhyscData[] x = { // 키의 오름차순으로 정렬되어 있습니다.
      new PhyscData("임대현", 186, 0.1),
        new PhyscData("이수민", 175, 2.0),
        new PhyscData("이호연", 174, 1.2),
        new PhyscData("전서현", 173, 0.7),
        new PhyscData("홍준기", 171, 1.5),
        new PhyscData("김한결", 169, 0.8),
        new PhyscData("유지훈", 168, 0.4),
        new PhyscData("이나령", 162, 0.3),
    };

    System.out.println("===== 정렬 전 =====");
    for (PhyscData i : x) {
      System.out.printf("%s\n", i.toString());
    }
    
    Arrays.sort(x, (a, b) -> (int)b.getVision() - (int)a.getVision());
    
    System.out.println("===== 정렬 후 =====");
    for (PhyscData i : x) {
      System.out.printf("%s\n", i.toString());
    }

    System.out.print("시력이 몇인 사람을 찾고 있나요? ： ");

    double vision = scan.nextDouble(); // 키 값 입력
    int idx = Arrays.binarySearch(
        x, // 배열x에서
        new PhyscData("", 0, vision), // 키가 height인 요소를
        PhyscData.VISION_ORDER // VISION_ORDER 에 의해 검색
    );

    if (idx < 0) {
      System.out.println("요소가 없습니다.");
    } else {
      System.out.println("x[" + idx + "]에 있습니다.");
      System.out.println("찾은 데이터：" + x[idx]);
    }

    scan.close();
  }
}