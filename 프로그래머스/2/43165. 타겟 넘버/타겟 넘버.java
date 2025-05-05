class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        int[] operators = {1, -1};
        dfs(0, 0, operators, numbers, target);
        return answer;
    }
    
    private void dfs(int sum, int depth, int[] operators, int[] numbers, int target) {
        if(depth == numbers.length) {
            if(sum == target) answer++;
        } else {
            for(int o: operators) {
                dfs(sum + o*numbers[depth], depth+1, operators, numbers, target);
            }
        }
    }
}