import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        // 스택에 마지막 인덱스 추가
        stack.push(0);

        // 반복문 (주가 배열의 마지막 인덱스 - 1 부터 감소)
        for (int i = 1; i < prices.length ; i++) {

            // 반복문 2 (while 조건: 스택 존재 && 스택의 top의 값 > 인덱스의 값)
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                answer[stack.peek()] = i - stack.pop();
            }

            // 스택에 추가한다.
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            // 결과값의 인덱스 값 = 전체 길이 - 스택의 인덱스 값
            answer[stack.peek()] = prices.length - stack.peek() -1;
            stack.pop();
        }
        
        return answer;
    }
}