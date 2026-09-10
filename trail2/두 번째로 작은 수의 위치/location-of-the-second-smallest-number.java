import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int minIdx = -1;
        int secondIdx = -1;
        int minCount = 0;
        int secondCount = 0;

        for (int i = 0; i < N; i++) {
            if (minIdx == -1 || arr[i] < arr[minIdx]) {
                // 기존 최솟값이 두 번째로 작은 값이 됨
                secondIdx = minIdx;
                secondCount = minCount;

                minIdx = i;
                minCount = 1;
            } else if (arr[i] == arr[minIdx]) {
                minCount++;
            } else if (secondIdx == -1 || arr[i] < arr[secondIdx]) {
                secondIdx = i;
                secondCount = 1;
            } else if (arr[i] == arr[secondIdx]) {
                secondCount++;
            }
        }

        if (secondIdx == -1 || secondCount != 1) {
            System.out.println(-1);
        } else {
            System.out.println(secondIdx + 1);
        }
    }
}
