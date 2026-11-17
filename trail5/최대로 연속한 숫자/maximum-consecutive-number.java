import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] removed = new int[M];
        long[] answer = new long[M];
        int ans_index = 0;
        int[] cut = new int[M + 2]; // 양끝을 추가해야할 2칸을 더 만들어줌
        cut[0] = -1; // 모든수는 0 보다 크다
        cut[M + 1] = N + 1; // 모든수는 N보다는 작다
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            removed[i] = num;
            cut[i + 1] = num;
        }
        Arrays.sort(cut);
        // 각 숫자가 정렬된 배열의 몇번째에 있는지 저장
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= M; i++) {
            map.put(cut[i], i);
        }
        // 경계의 왼쪽, 오른쪽 이웃 칸 번호를 저장 -> 나중에 갯수를 세기 위해서 저장
        int[] left = new int[M + 2];
        int[] right = new int[M + 2];

        for (int i = 0; i < M + 2; i++) {
            left[i] = i - 1;
            right[i] = i + 1;
        }
        long longest = 0;
        for (int i = 0; i <= M; i++) {
            long length = (long) cut[i + 1] - cut[i] - 1;
            longest = Math.max(longest, length);
        }
        answer[ans_index++] = longest;
        for (int i = M - 1; i >= 1; i--) {
            int idx = map.get(removed[i]); // 거꾸로 하나씩 복원 -> cut 배열에서 해당 숫자가 어디있는지 확인
            int l = left[idx];
            int r = right[idx];

            // 새로 합쳐진 구간만 확인 자신의 오른쪽 - 왼쪽 -1 = 갯수
            long length = (long) cut[r] - cut[l] - 1;
            longest = Math.max(longest, length);

            // 내가 삭제한값의 오른쪽 왼쪽 index를 갱신
            right[l] = r;
            left[r] = l;
            answer[ans_index++] = longest;
        }
        for (int i = M - 1; i >= 0; i--) {
            System.out.println(answer[i] + " ");
        }

    }

}
