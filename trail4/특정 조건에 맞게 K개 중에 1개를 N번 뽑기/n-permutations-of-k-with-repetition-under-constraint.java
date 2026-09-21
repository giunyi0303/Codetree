import java.io.*;
import java.util.*;

  public class Main {
      private static int K;
      private static int N;
      private static int[] temp;
      private static StringBuilder answer = new StringBuilder();

      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          K = sc.nextInt();
          N = sc.nextInt();

          temp = new int[N];
          permutation(0);

          System.out.print(answer);
      }

      private static void permutation(int count) {
          if (count == N) {
              for (int i = 0; i < N; i++) {
                  if (i > 0) {
                      answer.append(' ');
                  }
                  answer.append(temp[i]);
              }
              answer.append('\n');
              return;
          }

          for (int number = 1; number <= K; number++) {
              if (count >= 2
                      && temp[count - 1] == number
                      && temp[count - 2] == number) {
                  continue;
              }

              temp[count] = number;
              permutation(count + 1);
          }
      }
  }