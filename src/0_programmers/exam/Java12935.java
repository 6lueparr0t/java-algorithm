// https://programmers.co.kr/learn/courses/30/lessons/12935
// 제일 작은 수 제거하기

public class Java12935 {
    public int[] solution(int[] arr) {
        int[] answer = new int[(arr.length>1)?arr.length-1:1];
        
        if(arr.length < 2) {
            answer[0] = -1;
            return answer;
        }
        
        int min = arr[0];
        int minIndex = 0;
        for(int i=0; i<arr.length; i++) {
            if(min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
        }
        
        int i = 0;
        int j = 0;
        while(i<answer.length) {
            if(minIndex == j) {
                j++;
                continue;
            }
            answer[i++] = arr[j++];
        }
        
        return answer;

        // 이런 방법도 있었다.
        // if (arr.length <= 1) return new int[]{ -1 };
        // int min = Arrays.stream(arr).min().getAsInt();
        // return Arrays.stream(arr).filter(i -> i != min).toArray();
    }
}
