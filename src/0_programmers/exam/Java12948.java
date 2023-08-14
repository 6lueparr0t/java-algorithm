// https://programmers.co.kr/learn/courses/30/lessons/12948
// 마지막 4자리 공개

public class Java12948 {
  public static void main(String[] args) {
    // char[] arr = phone_number.toCharArray();

    // for(int i=0; i<arr.length-4; i++) {
    // arr[i] = '*';
    // }

    // return String.valueOf(arr);
    
    String phone_number = "0211116789";
    System.out.println(
        "*".repeat(phone_number.length() - 4)
            + phone_number.substring(phone_number.length() - 4, phone_number.length()));

    // 이런 방법도 있다.
    // phone_number.replaceAll(".(?=.{4})", "*");
  }
}
