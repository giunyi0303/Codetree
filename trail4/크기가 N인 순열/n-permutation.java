import java.util.*;
public class Main {
    private static int n;
    private static int [] arr;
    private static boolean [] sel;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        sel = new boolean[n+1];
        dfs(0);
    }
    private static void dfs(int count)
    {
        if(count == n)
        {
            for(int i = 0; i<n; i++)
            {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i =1; i<=n; i++)
        {
            if(!sel[i])
            {
                arr[count] = i;
                sel[i] = true;
                dfs(count+1);
                sel[i] = false;
            }
            

        }
    }
}