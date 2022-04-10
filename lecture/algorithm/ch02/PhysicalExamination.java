package lecture.algorithm.ch02;

public class PhysicalExamination {
  static final int VMAX = 20; //시력 분포(0.0 에서 0.1 단위로 21개)

  static class PhyscData {
    String name;
    int height;
    double vision;

    PhyscData(String name, int height, double vision) {
      this.name = name;
      this.height = height;
      this.vision = vision;
    }
  }

  // 키의 평균값
  static double aveHeight(PhyscData[] dat) {
    double sum = 0;

    for (int i=0; i<dat.length; i++) {
      sum += dat[i].height;
    }

    return sum / dat.length;
  }

  // 시력 분포
  static void distVision(PhyscData[] dat, int[] dist) {
    int i=0;

    dist[i] = 0;

    for (i=0; i<dat.length; i++) {
      if (dat[i].vision > 0.0 && dat[i].vision <= VMAX / 10.0) {
        dist[(int)(dat[i].vision * 10)-1]++;
      }
    }
  }

  public static void main(String[] args) {
    PhyscData[] x = {
      new PhyscData("A", 162, 0.3),
      new PhyscData("B", 173, 0.7),
      new PhyscData("C", 175, 2.0),
      new PhyscData("D", 171, 1.5),
      new PhyscData("E", 168, 0.4),
      new PhyscData("F", 174, 1.2),
      new PhyscData("G", 169, 0.8),
    };

    int[] vdist = new int[VMAX];

    System.out.println("- 신체검사 리스트 -");
    System.out.println("이름      키  시력");
    System.out.println("---------------");

    for (int i=0; i<x.length; i++) {
      System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
    }

    System.out.printf("\n평균 키 : %5.1fcm\n", aveHeight(x));

    distVision(x, vdist);

    System.out.println("\n시력 분포");

    for (int i=1; i<=VMAX; i++) {
      System.out.printf("%3.1f~ : %s\n", i/10.0, "*".repeat(vdist[i-1]));
    }
  }
}
