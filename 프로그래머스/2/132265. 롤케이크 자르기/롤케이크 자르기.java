import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> cheolCake = new HashMap<>();
        Map<Integer, Integer> broCake = new HashMap<>();
        
        for(int i = 0; i < topping.length; i++) {
            broCake.put(topping[i], broCake.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i = 0; i < topping.length; i++) {
            cheolCake.put(topping[i], broCake.getOrDefault(topping[i], 0) + 1);
            
            if(broCake.get(topping[i]) == 1) {
                broCake.remove(topping[i]);
            } else {
                broCake.put(topping[i], broCake.getOrDefault(topping[i], 0) - 1);
            }
            
            if(cheolCake.size() == broCake.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}