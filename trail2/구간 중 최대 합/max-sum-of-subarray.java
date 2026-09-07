  import java.util.*;

  public class Main {
      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          int n = sc.nextInt();
          int k = sc.nextInt();

          int[] arr = new int[n];

          for (int i = 0; i < n; i++) {
              arr[i] = sc.nextInt();
          }

          int sum = 0;

          for (int i = 0; i < k; i++) {
              sum += arr[i];
          }

          int answer = sum;

          for (int i = k; i < n; i++) {
              sum -= arr[i - k];
              sum += arr[i];

              answer = Math.max(answer, sum);
          }

          System.out.println(answer);
          sc.close();
      }
  }