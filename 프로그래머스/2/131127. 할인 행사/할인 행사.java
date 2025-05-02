import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        // 날짜 별 루프
        for(int i = 0; i < discount.length - 9; i++) {
            boolean isAllDayDiscount = true;
            Map<String, Integer> map = new HashMap<>();
            
            // 날짜 별 할인 개수 매핑
            for(int j = 0; j < 10; j++) {
                String item = discount[i+j];
                map.put(item, map.getOrDefault(item, 0) + 1);
            }
            
            // 제품 별 할인 개수가 부족한지 체크
            for(int k = 0; k < want.length; k++) {
                if(map.getOrDefault(want[k], 0) != number[k]) {
                    isAllDayDiscount = false;
                    break;
                }
            }
            
            if (isAllDayDiscount) {
                answer++;
            }
        }
        
        return answer;
    }
}