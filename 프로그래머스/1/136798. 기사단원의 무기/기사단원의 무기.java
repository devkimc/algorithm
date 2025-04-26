import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        // 기사 번호
        for(int i = 1; i <= number; i++) {
            
            Set<Integer> divisorSet = new HashSet();
            
            // 약수 구하기
            for(int j = 1; j <= Math.sqrt(i); j++) {
                if(i%j == 0) {
                    divisorSet.add(i / j);
                    divisorSet.add(j);
                }
            }
            
            if(divisorSet.size() > limit) {
                answer += power;
            } else {
                answer += divisorSet.size();
            }
        }
        
        return answer;
    }
}