import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2023-08-25 시작
 */
public class Day1 {
  private static class PhoneNumber {
    public final String phoneNumber;

    public PhoneNumber(String rawPhoneNumber) {
      this.phoneNumber = rawPhoneNumber.replaceAll("[^0-9]", "");
    }

    @Override
    public String toString() {
      return "PhoneNumber{phoneNumber='" + phoneNumber + "'}";
    }

    // contains 에서 phoneNumber 랑 비교하기 위해 추가
    @Override
    public boolean equals(Object o) {
      if (!(o instanceof PhoneNumber)) return false;
      return phoneNumber.equals(((PhoneNumber) o).phoneNumber);
    }
  }

  private static class Person {
    public final String name;
    private final List<PhoneNumber> numbers;

    public Person(String name) {
      this.name = name;
      numbers = new ArrayList<>();
    }

    public void addPhoneNumber(PhoneNumber number) {
      numbers.add(number);
    }

    // number가 전화번호 형식이면 추가하고 true 반환
    // 전화번호 형식이 아니면 추가하지 않고 false 반환
    public boolean addPhoneNumber(String number) {
      for (char c : number.toCharArray()) {
        if (!Character.isDigit(c)) return false;
      }

      numbers.add(new PhoneNumber(number));
      return true;
    }

    @Override
    public String toString() {
      return "Person{"+
        "name='" + name + "', \n" +
        "numbers=" + numbers + "\n" +
        "}";
    }

    public boolean hasPhoneNumber(PhoneNumber number) {
      return numbers.contains(number);
    }
  }

  private static class PhoneBook {
    private final Set<Person> people;

    private PhoneBook() {
      people = new HashSet<>();
    }

    public void addPerson(Person person) {
      people.add(person);
    }

    @Override
    public String toString() {
      return "PhoneBook{" + "people=" + people + "}";
    }

    public Person search(PhoneNumber number) {
      return people.stream().filter(p -> p.hasPhoneNumber(number)).findFirst().orElse(null);

      // Stream 코드를 해석하면 다음과 같다.
      // for (Person p : people) {
      //   if (p.hasPhoneNumber(number)) {
      //     return p;
      //   }
      // }
    }
  }

  public static void main(String[] args) {
    // Person 객체 생성
    Person person = new Person("홍길동");

    // 특수문자를 제거한 전화번호만 받을 수 있도록
    person.addPhoneNumber(new PhoneNumber("010-1234-5678"));
    person.addPhoneNumber(new PhoneNumber("010 1234 5678"));
    person.addPhoneNumber(new PhoneNumber("01012345678"));

    // 숫자만 받을 수 있도록
    person.addPhoneNumber("01000000000");
    person.addPhoneNumber("a");

    System.out.println(person);

    // 문자열 비교
    System.out.println(person.hasPhoneNumber(new PhoneNumber("01012345678")));

    Person person1 = new Person("홍길동");
    person1.addPhoneNumber(new PhoneNumber("010-1111-1111"));
    person1.addPhoneNumber(new PhoneNumber("010-2222-2222"));

    Person person2 = new Person("김철수");
    person2.addPhoneNumber(new PhoneNumber("010-3333-3333"));

    Person person3 = new Person("이영희");
    person3.addPhoneNumber(new PhoneNumber("010-4444-4444"));

    PhoneBook phoneBook = new PhoneBook();
    phoneBook.addPerson(person1);
    phoneBook.addPerson(person2);
    phoneBook.addPerson(person3);

    System.out.println(phoneBook);

    System.out.println(phoneBook.search(new PhoneNumber("01011111111")));
    System.out.println(phoneBook.search(new PhoneNumber("01055555555")));
  }
}
