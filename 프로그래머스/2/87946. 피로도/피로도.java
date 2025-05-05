class Solution {
    private static int answer = 0;
    private static boolean[] visited = {};
    private static int[][] dungeons = {};
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        this.dungeons = dungeons;
        
        dfs(0, k);
        
        return answer;
    }
    
    private static void dfs(int depth, int k) {
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(depth+1, k-dungeons[i][1]);
                visited[i] = false;
            }
        }
        
        answer = Math.max(answer, depth);
    }
}