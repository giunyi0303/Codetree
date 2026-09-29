import java.util.*;
public class Main {
    private static int [] arr;
    private static int n;
    private static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int [n];
        ans = 0;
        permutation(0);
        System.out.println(ans);
    }
    private static void permutation(int count)
    {
         if (count == n) {
      int idx = 0;

      while (idx < n) {
          int num = arr[idx];
          int cnt = 0;

          while (idx < n && arr[idx] == num) {
              cnt++;
              idx++;
          }

          if (cnt % num != 0) {
              return;
          }
      }

      ans++;
      return;
  }
        
        for(int i = 1; i<=4; i++)
        {
            arr[count] = i;
            permutation(count+1); 
        }
    }
}