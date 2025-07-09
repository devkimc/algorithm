import java.util.*;

class Solution {

  public int solution(String skill, String[] skill_trees) {

    // skill 을 HashSet 에 넣는다.

    // 스킬트리 Loop
      // 큐에 스킬 순서대로 스킬 입력
      // 스킬트리의 각 스킬 Loop
        // set에 존재하는 경우
          // poll
          // poll 결과값이 null 인 경우 break
        // set에 존재하지 않는 경우
          // continue
        // 마지막 스킬인 경우 answer++;
    
    int answer = 0;

    Set<Character> set = new HashSet<>();
    for (char c : skill.toCharArray()) {
      set.add(c);
    }

    for (String tree : skill_trees) {
      Queue<Character> queue = new ArrayDeque<>();
      for (char c : skill.toCharArray()) {
        queue.add(c);
      }

      for (int i = 0; i < tree.length(); i++) {
        if (set.contains(tree.charAt(i))) {
          if (tree.charAt(i) != queue.poll()) {
            break;
          }
        }

        if (i == tree.length() - 1) answer++;
      }
    }

    return answer;
  }
}