class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int startPosition = 0;
        
        for (int i = 0; i < section.length; i++) {
            if(i == 0 || section[i] - startPosition >= m) {
                startPosition = section[i];
                answer++;
            }
        }
        
        return answer;
    }
}