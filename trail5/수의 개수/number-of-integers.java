import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int [] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        num = new int [N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++)
        {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int [] answer = new int [M];
        for(int i = 0; i<M; i++)
        {
            int number = Integer.parseInt(br.readLine());
            answer[i] = upperbound(number) - lowerbound(number);
        }
        for(int ans : answer)
        {
            System.out.println(ans);
        }
        
    }
    private static int lowerbound(int target)
    {
        int left = 0;
        int right = N-1;
        int idx = N;
        while(left<= right)
        {
            int mid = left+ (right - left) / 2;
            if(num[mid]>=target)
            {
                right = mid-1;
                idx = Math.min(idx,mid);
            }
            else
            {
                left = mid+1;
            }
        }
        return idx;
    }

    private static int upperbound(int target)
    {
        int left = 0;
        int right = N-1;
        int idx = N;
        while(left<= right)
        {
            int mid = left+ (right - left) / 2;
            if(num[mid]>target)
            {
                right = mid-1;
                idx = Math.min(idx,mid);
            }
            else
            {
                left = mid+1;
            }
        }
        return idx;
    }

}
