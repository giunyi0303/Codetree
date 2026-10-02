import java.util.Scanner;
public class Main {
    private static int n;
    private static int [][] map;
    private static boolean [] visited;
    private static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean [n];
        ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                map[i][j] = sc.nextInt();
        fun(0,0);
        System.out.println(ans);
    }
    private static void fun(int count , int num)
    {
        if(count == n)
        {
            ans = Math.max(ans , num);
            return;
        }
        for(int col = 0; col<n; col++)
        {
            if(!visited[col])
            {
                visited[col] = true;
                fun(count+1,num+map[count][col]); 
                visited[col] = false;
            }
        }
    }
}