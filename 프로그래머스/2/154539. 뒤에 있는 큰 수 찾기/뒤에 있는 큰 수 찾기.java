import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        // 인덱스로 스택을 관리한다. 이후에 뒷큰수가 존재하지 않을 경우 인덱스에 해당하는 값만 -1로 변경
        stack.push(0);
        
        // 숫자 배열 Loop
        for(int i = 1; i < numbers.length; i++) {
            
            // 뒷큰수를 만나면 stack 에 쌓인 나머지 원소도 비교하여 조건이 충족하면 pop 시킨다.
            while(!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
                answer[stack.pop()] = numbers[i];    
            }
            stack.push(i);
        }
        
        // 뒷큰수가 존재하지 않는 원소들을 인덱스를 사용하여 -1로 변경
        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}