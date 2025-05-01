import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> answerList = new ArrayList<>();
        
        // 시작과 끝의 {{, }} 제거
        String[] tupleArray = s.substring(2, s.length() - 2) 
                               .split("\\},\\{");
        
        // 튜플의 원소의 개수만큼 루프를 돌기 위함
        for(String tupleElementIncludedComma: tupleArray) {
            
            // 다음 원소를 찾아야 함
            for(String tupleElementIncludedCommaForAnswer: tupleArray) {
                int[] tupleElementArray = Arrays.stream(tupleElementIncludedCommaForAnswer.split(","))
                                                .mapToInt(Integer::parseInt)
                                                .toArray();
                
                // 튜플 원소의 길이 == answer 길이 + 1 일 경우, 다음 원소임
                if(tupleElementArray.length == answerList.size() + 1) {
                    
                    // 다음 원소 = 튜플 원소의 합 - answer의 합
                    int nextElement = Arrays.stream(tupleElementArray).sum() - answerList.stream().mapToInt(i->i).sum();
                    answerList.add(nextElement);
                    break;
                }
            }
        }
        
        return answerList.stream().mapToInt(i->i).toArray();
    }
}