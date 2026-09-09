  import java.util.Scanner;

  public class Main {
      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();

          int win1 = 0;
          int win2 = 0;

          for (int i = 0; i < n; i++) {
              int a = sc.nextInt();
              int b = sc.nextInt();

              if (a == b) {
                  continue;
              }

              if ((a == 1 && b == 2) ||
                  (a == 2 && b == 3) ||
                  (a == 3 && b == 1)) {
                  win1++;
              } else {
                  win2++;
              }
          }

          System.out.println(Math.max(win1, win2));
      }
  }