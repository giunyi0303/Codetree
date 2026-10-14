import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i<n; i++)
        {
            queue.add(arr[i]);
        }
        int cost = 0;
        while (queue.size() > 1) 
        {
        int a = queue.poll();
        int b = queue.poll();
        cost += a + b;
        queue.add(a + b);
        }
        System.out.println(cost);
    }


}