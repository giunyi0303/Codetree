  import java.util.*;

  public class Main {
      private static int[] ans;
      private static int n;
      private static int m;

      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          n = sc.nextInt();
          m = sc.nextInt();

          ans = new int[m];

          combination(0, 1);
      }

      private static void combination(int count, int start) {
          if (count == m) {
              for (int i = 0; i < m; i++) {
                  if (i > 0) {
                      System.out.print(" ");
                  }
                  System.out.print(ans[i]);
              }
              System.out.println();
              return;
          }

          for (int number = start; number <= n; number++) {
              ans[count] = number;

              combination(count + 1, number + 1);
          }
      }
  }