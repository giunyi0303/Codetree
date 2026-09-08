import java.util.*;

public class Main {
    private static int total;
    private static int ans;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ability = new int[6];
        for (int i = 0; i < 6; i++) {
            ability[i] = sc.nextInt();
            total += ability[i];
        }
        ans = Integer.MAX_VALUE;
        visited = new boolean[6];
        subset(ability, 0 , 0);
        System.out.println(ans);

    }

    private static void subset(int[] ability, int index, int count) {
          if (count == 3) {
              int temp = 0;

              for (int i = 0; i < 6; i++) {
                  if (visited[i]) {
                      temp += ability[i];
                  }
              }

              int other = total - temp;
              ans = Math.min(ans, Math.abs(other - temp));
              return;
          }
          if (index == 6) {
              return;
          }

          visited[index] = true;
          subset(ability, index + 1, count + 1);

          visited[index] = false;
          subset(ability, index + 1, count);
      }
}
