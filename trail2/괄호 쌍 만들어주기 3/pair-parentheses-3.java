import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == '(')
                for (int j = i + 1; j < n; j++) {
                    if (str.charAt(j) == ')') {
                        answer++;
                    }
                }
        }
        System.out.println(answer);
    }
}