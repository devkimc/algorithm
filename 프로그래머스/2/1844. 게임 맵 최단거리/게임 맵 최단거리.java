import java.util.*;

class Solution {
    
    public int solution(int[][] maps) {
        int[][] moves = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int[][] visited = new int[maps.length][maps[0].length];
        int answer = 0;
        
        // 첫 칸에서 시작하므로 첫 칸 방문 처리
        visited[0][0] = 1;
        
        this.bfs(maps, visited, moves);
        
        answer = visited[maps.length-1][maps[0].length-1];
        
        return answer == 0 ? -1 : answer;
    }
    
    private void bfs(int[][] maps, int[][] visited, int[][] moves) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        
        while(!q.isEmpty()) {
            int[] c = q.poll();
            
            for(int[] move: moves) {
                int nX = c[0]+move[0];
                int nY = c[1]+move[1];
                
                // 다음 칸이 맵을 벗어나는 영역인지 체크
                if(nX < 0 || nX > maps.length-1 || nY < 0 || nY > maps[0].length-1) {
                    continue;
                }
                
                // 다음 칸을 방문하지 않았는지, 벽이 아닌지 체크
                if(visited[nX][nY] == 0 && maps[nX][nY] != 0) {
                    visited[nX][nY] = visited[c[0]][c[1]]+1;
                    q.add(new int[]{nX, nY});
                }
            }
        }
    }
}