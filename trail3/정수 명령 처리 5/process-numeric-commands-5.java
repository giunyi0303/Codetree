import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int m = 0;
            if (order.equals("push_back") || order.equals("get")) {
                m = Integer.parseInt(st.nextToken());
            }

            switch (order) {
            case "push_back":
                stack.add(m);
                break;
            case "get":
                System.out.println(stack.get(m - 1));
                break;
            case "size":
                System.out.println(stack.size());
                break;
            case "pop_back":
                stack.pop();
                break;
            }
        }
    }
}