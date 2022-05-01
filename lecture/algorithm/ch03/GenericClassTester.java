// 제네릭 클래스의 예
public class GenericClassTester {
  // 제네릭 클래스의 파라미터를 T라고 작성
  static class GenericClass<T> {
    private T xyz;

    GenericClass(T t) { // 생성자
      this.xyz = t;
    }

    T getXyz() { // xyz 를 반환
      return xyz;
    }
  }

  public static void main(String[] args) {
    // 다음과 같이 파라미터에 String 을 넘길 수도 있고 Integer 를 넘길 수도 있음.
    GenericClass<String> s = new GenericClass<String>("6lueparr0t");
    GenericClass<Integer> i = new GenericClass<Integer>(1991);

    System.out.println(s.getXyz());
    System.out.println(i.getXyz());
  }
}
