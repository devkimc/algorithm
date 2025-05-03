class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[Math.toIntExact(right-left)+1];
        
        // 행: 인덱스/n + 1, 열: 인덱스%n + 1
        int index = 0;
        for(long i = left; i <= right; i++) {
            long row = i/n+1;
            long col = i%n+1;
            
            // index value =  행과 열의 최댓값
            answer[index++] = Math.toIntExact(Math.max(row, col));
        }
        
        return answer;
    }
}