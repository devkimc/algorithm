import java.util.*;

class Solution {

    public long solution(int n, int[] works) {        
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        // 우선 순위 큐에 모든 데이터를 넣는다.
        for (int work : works) {
            queue.offer(work);
        }

        while (n-- > 0) {
            // 큐의 front가 0인 경우 반복문을 종료한다.
            if (queue.peek() == 0) break;

            // 작업 시간을 감소시키고 다시 큐에 넣어준다.
            queue.offer(queue.poll() - 1);
        }

        while (!queue.isEmpty()) {
            answer += (long) Math.pow(queue.poll(), 2);
        }
        
        return answer;
    }

}