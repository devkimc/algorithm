import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for (int i = 1; i < prices.length ; i++) {

            // 반복문 (스택의 top의 값 > 인덱스의 값)
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                answer[stack.peek()] = i - stack.pop();
            }

            stack.push(i);
        }

        // 가격이 떨어진 적이 없는 가격에 대한 결과값 설정
        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.pop() -1;
        }
        
        return answer;
    }
}