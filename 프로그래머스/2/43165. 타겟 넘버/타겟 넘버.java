class Solution {
    int answer = 0;
    int[] operators = {1, -1};
    
    public int solution(int[] numbers, int target) {
        this.dfs(0, 0, target, numbers);
        return answer;
    }

  private void dfs(int depth, int sum, int target, int[] numbers) {
    if (depth == numbers.length) {
      if (sum == target) {
        answer++;
      }
    } else {
      for (int i : operators) {
        dfs(depth + 1, sum + i*numbers[depth], target, numbers);
      }
    }
  }
}