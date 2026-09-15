import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Stack<Character> stack = new Stack<>();
        boolean flag = true;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    flag = false;
                    break;
                }

                stack.pop();
            }
        }

        if (flag && stack.isEmpty()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}