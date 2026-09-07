import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] people = new int[n][2];

        for (int i = 0; i < n; i++) {
            int pos = sc.nextInt();
            char c = sc.next().charAt(0);

            people[i][0] = pos;
            people[i][1] = (c == 'G') ? 1 : 2;
        }

        Arrays.sort(people, Comparator.comparingInt(person -> person[0]));

        int left = 0;
        int currentScore = 0;
        int answer = 0;

        for (int right = 0; right < n; right++) {
            currentScore += people[right][1];

            while (people[right][0] - people[left][0] > k) {
                currentScore -= people[left][1];
                left++;
            }

            answer = Math.max(answer, currentScore);
        }

        System.out.println(answer);
        sc.close();
    }
}