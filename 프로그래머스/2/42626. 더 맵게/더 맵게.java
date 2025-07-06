import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        // 우선순위 큐에 데이터를 모두 추가 (오름차순)
        for(int s: scoville) {
            queue.offer(s);
        }
        
        while(queue.peek() < K && queue.size() > 1) {
            // 두개의 데이터를 꺼내서 섞은 후의 스코빌 지수를 계산
            queue.offer(queue.poll() + queue.poll() * 2);
            answer++;
        }
        
        return queue.peek() >= K ? answer : -1;
    }
}