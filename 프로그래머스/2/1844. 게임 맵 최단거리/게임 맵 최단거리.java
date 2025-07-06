import java.util.*;

class Solution {
    private final int[][] d = {{1, 0},{0, 1},{-1, 0},{0, -1}};
    
    public int solution(int[][] maps) {
        // 빠르게 도착하는 방법 bfs
        // 가설: 최단 거리 경로는 이미 방문한 경로를 지나치지 않는다.

        // 시작 위치를 큐에 입력한다.
        // while 반복문 (큐가 존재할 경우 반복)
            // 큐에서 데이터를 추출한다.
            // for 반복문을 돌면서 각 이동 선택지 별로 (상, 하, 좌, 우) 
            // if 방문을 안했고, 맵을 벗어벽이 아닌 경로로만 간다.
                // 방문 처리 한다.
                // 이동 위치를 큐에 입력한다.
        
        // 모든 경로를 탐색 후 목적지 [4][4] 에 방문하지 못했을 경우 -1 return
        // 궁금증: queue 대신 stack 으로 풀면 안되는 건가?
        
        int answer = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[][] distance = new int[maps.length][maps[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[]{0, 0});
        distance[0][0] = 1;
        
        while(!queue.isEmpty()) {
            int[] p = queue.poll();
            
            for(int i = 0; i < d.length; i++) {
                int nX = p[0] + d[i][0];
                int nY = p[1] + d[i][1];
                if(nX >= 0 && nX < maps.length && 
                   nY >= 0 && nY < maps[0].length && 
                   maps[nX][nY] != 0 &&
                   !visited[nX][nY]) {
                    visited[nX][nY] = true;
                    queue.offer(new int[]{nX, nY});
                    distance[nX][nY] = distance[p[0]][p[1]] + 1;
                }
            }
        }
        
        answer = distance[maps.length - 1][maps[0].length - 1];
        return answer > 0 ? answer : -1;
    }
    
}