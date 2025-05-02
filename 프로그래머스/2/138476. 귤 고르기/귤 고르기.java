import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int t: tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> countList = new ArrayList<>(map.values());
        countList.sort(Comparator.reverseOrder());
        
        for(int count : countList) {
            answer++;
            
            // 동일한 귤의 개수가 많더라도 최솟값을 구해야 하므로 1번만 증가시키고 종료 - 남은 귤을 상자에 모두 담는 경우
            if(count >= k) {
                break;
            } else {
                k -= count;
            }
        }
        
        return answer;
    }
}