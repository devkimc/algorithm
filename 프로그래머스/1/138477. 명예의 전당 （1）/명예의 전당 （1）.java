import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> honor = new ArrayList<>();
        
        for(int i = 0; i < score.length; i++) {
            //1. 점수를 추가한다
            honor.add(score[i]);
            //2. 내림차순으로 정렬한다
            Collections.sort(honor, Collections.reverseOrder());
            //3. k일 이후라면 마지막 요소를 제거한다.
            if(i >= k) honor.remove(honor.size() - 1);
            //4. 마지막 요소를 answer에 추가한다.
            answer[i] = honor.get(honor.size() - 1);
        }
        
        return answer;
    }
}