import java.util.*;
public class Main {
    private static int [] dx = {0,0,-1,1};
    private static int [] dy = {1,-1,0,0};
    private static int [][] grid;
    private static boolean [][] visited;
    private static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int k = sc.nextInt();
        grid = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                grid[i][j] = sc.nextInt();
        int[][] starts = new int[k][2];
        for (int i = 0; i < k; i++) {
            starts[i][0] = sc.nextInt() -1;
            starts[i][1] = sc.nextInt() -1;
        }
        int ans = 0;
        visited = new boolean[N][N];
        for(int i = 0; i<k; i++)
        {
            ans+= bfs(starts[i][0] , starts[i][1]);
        }
        System.out.println(ans);
        
    }
    private static int bfs(int i , int j)
    {
        Deque<int []> queue = new ArrayDeque<>();
        int count = 0;
        queue.add(new int [] {i , j});
        while(!queue.isEmpty())
        {
            int [] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if(visited[x][y])
            {
                continue;
            }
            visited[x][y] = true;
            count++;
            for(int dir =0; dir<4; dir++)
            {
                int nx = x+dx[dir];
                int ny = y+dy[dir];
                if(nx<0 || nx >=N || ny<0 || ny >=N)
                {
                    continue;
                }
                if(visited[nx][ny])
                {
                    continue;
                }
                if(grid[nx][ny] ==1)
                {
                    continue;
                }
                queue.add(new int [] {nx , ny});

            }
        }
        return count;
    }
}