import java.util.*;
import java.io.*;
public class Main {
    private static int [] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int [N+1];
        for(int i = 0; i<N+1; i++) // 초기화
        {
            parents[i] = i;
        }

        for(int i = 0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(order == 0)
            {
                union(a,b);
            }
            else
            {
                if(find(a) == find(b))
                {
                    System.out.println(1);
                }
                else
                {
                    System.out.println(0);
                }
            }
        }
        
    }
private static int find(int x)
{
    if(parents[x] == x)
    {
        return x;
    }
    return parents[x] = find(parents[x]);
}

private static void union(int x , int y)
{
    int rootA = find(x);
    int rootB = find(y);
    parents[rootA] = rootB;
}
    

}