import java.util.*;

public class Main {
    private static int n;
    private static int [][] grid;
    private static int [] dx = {0,0,-1,1};
    private static int [] dy = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
     PriorityQueue<Integer> ans = new PriorityQueue<>();           
        int count = 0;
        int total = 0;
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(grid[i][j] == 1)
                {
                    total++;
                    count = bfs(i,j);
                    ans.add(count);

                }
            }
        }  
        System.out.println(total);
        while(!ans.isEmpty())
        {
            System.out.println(ans.poll());
        }      
    }


    private static int bfs(int r , int c)
    {
        Deque <int []> queue = new ArrayDeque<int []>();
        queue.add(new int [] {r , c});
        grid[r][c] = 3; // 방문처리 기준 3
        int count = 1;
        while(!queue.isEmpty())
        {
            int [] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            for(int i = 0; i<4; i++)
            {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<0||nx>=n || ny<0 || ny>=n)
                {
                    continue;
                }
                if(grid[nx][ny] == 0 || grid[nx][ny] == 3)
                {
                    continue;
                }
                queue.add(new int [] {nx , ny});
                grid[nx][ny] = 3;
                count++;
            } 
        }
        return count;
        

        

    }
}