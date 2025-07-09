import java.util.*;

class Solution {

  private static final Map<String, Integer> bonusMap =
          Map.ofEntries(
                  Map.entry("S", 1),
                  Map.entry("D", 2),
                  Map.entry("T", 3)
          );

  private static final Map<String, Integer> prizeMap =
          Map.ofEntries(
                  Map.entry("*", 2),
                  Map.entry("#", -1),
                  Map.entry("", 1)
          );

  public int solution(String dartResult) {
    int answer = 0;

    // 정규식으로 숫자 앞에서 split 한다.
    String[] setArr = dartResult.replaceAll("([0-9]+)", "-$1").split("-");

    // 스택을 생성한다.
    Stack<Integer> stack = new Stack<>();

    for (int i = 1; i < setArr.length; i++) {
      ScoreSet set = new ScoreSet(setArr[i]);

      if ("*".equals(set.prize) && !stack.isEmpty()) {
        stack.add(stack.pop() * 2);
      }

      int finalScore = set.getFinalScore();

      stack.add(finalScore);
    }

    while (!stack.isEmpty()) {
      answer += stack.pop();
    }

    // 문자열 세트 수만큼 Loop
    // 스타상인 경우, 스택에 데이터가 존재하는지 확인하는지 확인
    // 존재할 경우
    // stack.add (stack.pop * 2)
    //
    // 현재값에 대해 연산한다.
    // 스택에 연산한 값을 추가한다.
    //String[0] // 점수
    //String[1] // 옵션 (존재하지 않을 수 있음)
    return answer;
  }

  private static class ScoreSet {
    private final int score;
    private final int bonus;
    private final String prize;

    ScoreSet(String strSet) {

      String strBonus = "";
      if (strSet.contains("S")) {
        strBonus = "S";
      } else if (strSet.contains("D")) {
        strBonus = "D";
      } else {
        strBonus = "T";
      }

      String[] set = strSet.split(strBonus);
      score = Integer.parseInt(set[0]);
      prize = set.length > 1 ? set[1] : "";
      bonus = bonusMap.get(strBonus);
    }

    private int getFinalScore() {
      int scoreByBonus = (int) Math.pow(score, bonus);
      return scoreByBonus * prizeMap.get(prize);
    }
  }
}