import java.util.*;

class Solution {

  public int[] solution(int[] fees, String[] records) {

    // fees: 요금 정책
    // records: 시간기준 오름차순으로 입,출차 기록

    // 차량별 이용
    // 기록 Loop
      // 차량별 출자 기록 Map 설정  (IN이면 추가, OUT이면 삭제)
      // 차량별 총 주차 시간 Map 설정  (없으면 추가, 있으면 증가)
    // 차량별 출차 Map Loop
      // 입차 기록만 존재하는 차량에 대해 주차 시간 계산
    // 차량별 시간 Map Loop (차량번호 오름차순으로 처리)
      // 차량별 요금 계산 후 결과값 설정

    Map<String, String> recordMap =  new HashMap<>();
    Map<String, Integer> usingTimeMap =  new HashMap<>();

    for(String strRecord: records) {
      Record record = new Record(strRecord);
      if (record.isIn()) {
        recordMap.put(record.vehicleNumber, record.time);
      } else {
        int beforeUsingTime = usingTimeMap.getOrDefault(record.vehicleNumber, 0);
        int currentUsingTime = getTimeDiff(record.time, recordMap.get(record.vehicleNumber));

        usingTimeMap.put(record.vehicleNumber, beforeUsingTime + currentUsingTime);
        recordMap.remove(record.vehicleNumber);
      }
    }

    for (String key : recordMap.keySet()) {
      int beforeUsingTime = usingTimeMap.getOrDefault(key, 0);
      int currentUsingTime = getTimeDiff("23:59", recordMap.get(key));

      usingTimeMap.put(key, beforeUsingTime + currentUsingTime);
    }

    List<String> vehicleNumberList = new ArrayList<>(usingTimeMap.keySet());
    Collections.sort(vehicleNumberList);

    int[] answer = new int[vehicleNumberList.size()];

    for (int i = 0; i < vehicleNumberList.size(); i++) {
      System.out.println("num: " + vehicleNumberList.get(i) + "usingTime: " + usingTimeMap.get(vehicleNumberList.get(i)));
      answer[i] = getFee(fees, usingTimeMap.get(vehicleNumberList.get(i)));
    }

    return answer;
  }

  private static class Record {
    private final String time;
    private final String vehicleNumber;
    private final String inOut;

    Record(String record) {
      String[] splited = record.split(" ");
      time = splited[0];
      vehicleNumber = splited[1];
      inOut = splited[2];
    }

    private boolean isIn() {
      return "IN".equals(inOut);
    }
  }

  private int getTimeDiff(String a, String b) {
    return getMinuteByTime(a) - getMinuteByTime(b);
  }

  private int getMinuteByTime(String time) {
    String[] splittedTime = time.split(":");
    return Integer.parseInt(splittedTime[0]) * 60 + Integer.parseInt(splittedTime[1]);
  }

  private int getFee(int[] fees, int usingTime) {
    int defaultUsingTime = fees[0];
    int defaultFee = fees[1];
    int unitTime = fees[2];
    int unitFee = fees[3];

    if (usingTime <= defaultUsingTime) {
      return defaultFee;
    }

    int feeByUniTime = (int) Math.ceil((float) (usingTime - defaultUsingTime) / unitTime);
    return defaultFee + feeByUniTime * unitFee;
  }
}