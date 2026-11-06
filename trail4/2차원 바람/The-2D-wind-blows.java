import java.util.*;
import java.io.*;

public class Main {
    private static int N, M, Q;
    private static int[][] map;
    private static int[][] pos;
    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        pos = new int[Q][4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken()) - 1;
            pos[i][1] = Integer.parseInt(st.nextToken()) - 1;
            pos[i][2] = Integer.parseInt(st.nextToken()) - 1;
            pos[i][3] = Integer.parseInt(st.nextToken()) - 1;
        }
        for (int i = 0; i < Q; i++) {
            change(pos[i][0], pos[i][1], pos[i][2], pos[i][3]);
            average(pos[i][0], pos[i][1], pos[i][2], pos[i][3]);
        }
        for (int temp[] : map) {
            for (int num : temp) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

    private static void change(int sx, int sy, int ex, int ey) {
        List<Integer> list = new ArrayList<>();
        // 1. 오른쪽
        for (int c = sy; c <= ey; c++) {
            list.add(map[sx][c]);
        }

        // 2. 아래쪽 (겹치는 모서리 방지->+1)
        for (int r = sx + 1; r <= ex; r++) {
            list.add(map[r][ey]);
        }

        // 3. 왼쪽(겹치는 모서리방지 -> -1)
        for (int c = ey - 1; c >= sy; c--) {
            list.add(map[ex][c]);
        }

        // 4. 위쪽(겹치는 모서리방지 -> -1)
        for (int r = ex - 1; r > sx; r--) {
            list.add(map[r][sy]);
        }
        // 1차원 배열 한칸씩 미는거
        Collections.rotate(list, 1);
        int idx = 0;

        // 1. 오른쪽
        for (int c = sy; c <= ey; c++) {
            map[sx][c] = list.get(idx++);
        }

        // 2. 아래
        for (int r = sx + 1; r <= ex; r++) {
            map[r][ey] = list.get(idx++);
        }

        // 3. 왼
        for (int c = ey - 1; c >= sy; c--) {
            map[ex][c] = list.get(idx++);
        }

        // 4. 위
        for (int r = ex - 1; r > sx; r--) {
            map[r][sy] = list.get(idx++);
        }

    }

    private static void average(int sx, int sy, int ex, int ey) {

        int[][] copy = new int[N][M];

        //배열을 복사
        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }

        // 직사각형 내부 평균 계산
        for (int x = sx; x <= ex; x++) {
            for (int y = sy; y <= ey; y++) {

                int sum = copy[x][y];
                int count = 1;

                for (int dir = 0; dir < 4; dir++) {
                    int nr = x + dx[dir];
                    int nc = y + dy[dir];

                    // 범위확인
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                        continue;
                    }

                    sum += copy[nr][nc];
                    count++;
                }

                map[x][y] = sum / count;
            }
        }
    }
}
