import java.util.*;
import java.util.stream.*;

class Solution {

  public int solution(int m, int n, int[][] puddles) {
    int[][] position = new int[m + 1][n + 1];
    boolean[][] isPuddle = new boolean[m + 1][n + 1];

    for (int[] puddle : puddles) {
      isPuddle[puddle[0]][puddle[1]] = true;
    }
    
    position[1][1] = 1;

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (isPuddle[i][j]) {
          position[i][j] = 0;
        } else if (i != 1 || j != 1){
          position[i][j] = (position[i - 1][j] + position[i][j - 1]) % 1000000007;
        }
      }
    }

    return position[m][n];
  }
}