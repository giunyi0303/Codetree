import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] blocks = new int[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
        }
        int s1 = sc.nextInt();
        int e1 = sc.nextInt();
        int s2 = sc.nextInt();
        int e2 = sc.nextInt();
        ArrayList<Integer> temp = new ArrayList<>();

        for (int block : blocks) {
            temp.add(block);
        }
        for (int i = e1; i >= s1; i--) {
            temp.remove(i - 1);
        }

        for (int i = e2; i >= s2; i--) {
            temp.remove(i - 1);
        }
        System.out.println(temp.size());
        if (temp.size() != 0) {
            for (int num : temp) {
                System.out.println(num);
            }
        }

    }

}