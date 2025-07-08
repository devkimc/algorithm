import java.util.*;

class Solution {
    public int solution(int[] order) {

    // 택배
      // 영재: (1~N) Queue
      // 보조 컨테이너: Stack
      // 택배기사: order Queue

    // 영재와 택배기사 택배 데이터 설정

    // whlie (택배기사 택배가 없는 경우)
      // 조건문
        // 영재 택배 없고, 보조 컨테이너 택배와 택배기사 택배 다른 경우 로직 종료
      // 영재 택배와 택배기사 택배 같다면
        // 영재 택배 추출
        // 택배기사 택배 추출
        // answer++;
      // 컨테이너 택배와 택배기사 택배 같다면
        // 컨테이너 택배 추출
        // 택배기사 택배 추출
        // answer++;
      // 나머지
        // 영재 택배 추출
        // 보조 컨테이너 입력

    int answer = 0;

    Queue<Integer> boy = new ArrayDeque<>();      // 영재 택배
    Queue<Integer> driver = new ArrayDeque<>();   // 택배기사 택배
    Stack<Integer> container = new Stack<>();     // 보조 컨테이너

    for (int i = 0; i < order.length; i++) {
      boy.add(i + 1);
      driver.add(order[i]);
    }

    while (!driver.isEmpty()) {
      if (boy.isEmpty() && !container.isEmpty() && !Objects.equals(container.peek(), driver.peek())) {
        break;
      }

      if (Objects.equals(boy.peek(), driver.peek())) {
        boy.poll();
        driver.poll();
        answer++;
      } else if (!container.isEmpty() && Objects.equals(container.peek(), driver.peek())) {
        container.pop();
        driver.poll();
        answer++;
      } else {
        container.add(boy.poll());
      }
    }
    return answer;
    }
}