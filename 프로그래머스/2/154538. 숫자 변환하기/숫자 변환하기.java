import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        // 큐를 생성한다.
        // 큐의 원소는 뎁스, 연산 결과값을 가진 배열 자료구조이다.
        
        // while 반복문 (큐 존재 시)
            // 큐 데이터 추출
            // 조건문 (연산 결과값 == y)
                // break depth
            // for 반복문 (연산 수 만큼)
                // 연산
                // 큐 add
        
        boolean[] visited = new boolean[y+1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, 0});
        
        while (!queue.isEmpty()) {
            int[] val = queue.poll();
            if(val[0] == y) {
                return val[1];
            }
            int[] nextVals = {val[0] + n, val[0] * 2, val[0] * 3};
                
            for(int nextVal : nextVals) {
                if(nextVal <= y && !visited[nextVal]) {
                    visited[nextVal] = true;
                    queue.add(new int[]{nextVal, val[1] + 1});
                }
            }
        }
        
        return -1;
    }
}