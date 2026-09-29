  import java.util.*;

  public class Main {
      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();

          int limit = 2 * n;
          int[] dist = new int[limit + 1];
          Arrays.fill(dist, -1);

          Deque<Integer> queue = new ArrayDeque<>();
          queue.add(1);
          dist[1] = 0;

          while (!queue.isEmpty()) {
              int num = queue.poll();

              if (num == n) {
                  System.out.println(dist[num]);
                  return;
              }

              int[] next = {num + 1, num - 1, num * 2, num * 3};
              for (int value : next) {
                  if (value < 1 || value > limit || dist[value] != -1) {
                      continue;
                  }
                  dist[value] = dist[num] + 1;
                  queue.add(value);
              }
          }
      }
  }