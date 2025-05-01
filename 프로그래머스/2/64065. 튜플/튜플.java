import java.util.*;

class Solution {
    public int[] solution(String s) {
        Set<String> answerSet = new LinkedHashSet<>();
        
        // 시작과 끝의 {{, }} 제거
        String[] tupleArray = s.substring(2, s.length() - 2) 
                               .split("\\},\\{");
        
        Arrays.sort(tupleArray, ((a, b) -> a.length() - b.length()));
        
        // 튜플의 원소의 개수만큼 루프를 돌기 위함
        for(String tupleElementArray: tupleArray) {
            
            // 다음 원소를 찾았을 경우 break
            for(String element: tupleElementArray.split(",")) {
                if(answerSet.add(element)) break;
            }
        }
        
        return answerSet.stream().mapToInt(Integer::parseInt).toArray();
    }
}