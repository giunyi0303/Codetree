import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long answer = 0;

        // 구간의 시작 위치
        for (int left = 0; left < n; left++) {
            long sum = 0;
            Map<Integer, Integer> frequency = new HashMap<>();

            // 구간의 끝 위치를 하나씩 늘림
            for (int right = left; right < n; right++) {
                sum += arr[right];

                frequency.put(arr[right], frequency.getOrDefault(arr[right], 0) + 1);

                int length = right - left + 1;

                // 평균이 정수인지 확인
                if (sum % length == 0) {
                    long average = sum / length;

                    // 평균값이 구간 내부에 존재하는지 확인
                    if (average >= Integer.MIN_VALUE && average <= Integer.MAX_VALUE
                            && frequency.containsKey((int) average)) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
        sc.close();
    }
}