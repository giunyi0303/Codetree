import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        long openCount = 0;
        long answer = 0;

        for (int i = 0; i < input.length() - 1; i++) {
            char current = input.charAt(i);
            char next = input.charAt(i + 1);

            if (current == '(' && next == '(') {
                openCount++;
            } else if (current == ')' && next == ')') {
                answer += openCount;
            }
        }

        System.out.println(answer);
        sc.close();
    }
}