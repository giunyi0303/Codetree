import java.util.*;

public class Main {
    private static int[] person_count;
    private static int answer = -1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        person_count = new int[n + 1];
        int[] penalizedPerson = new int[m];
        for (int i = 0; i < m; i++) {
            penalizedPerson[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int count = person_count[penalizedPerson[i]];
            count++;
            if (count == k) {
                answer = penalizedPerson[i];
                break;
            } else {
                person_count[penalizedPerson[i]] = count;
            }

        }
        System.out.println(answer);

    }
}