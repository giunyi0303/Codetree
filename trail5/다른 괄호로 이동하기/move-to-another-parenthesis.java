import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { -1, 1, 0, 0 };

    // 기호 ( -> 0 , ( -> 1로 표현
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken()); // 같을 때
        int b = Integer.parseInt(st.nextToken()); // 다를 때

        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int answer = 0;

        for (int startX = 0; startX < N; startX++) {
            for (int startY = 0; startY < N; startY++) {
                int[][] dist = new int[N][N];
                for (int i = 0; i < N; i++) {
                    Arrays.fill(dist[i], Integer.MAX_VALUE);
                }

                int start = map[startX][startY] == '(' ? 0 : 1;
                PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[3], o2[3]));

                dist[startX][startY] = 0;
                queue.add(new int[] { start, startX, startY, 0 });

                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    int sign = curr[0];
                    int x = curr[1];
                    int y = curr[2];
                    int currdist = curr[3];
                    if (dist[x][y] < currdist) {
                        continue;
                    }

                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                            continue;
                        }

                        int nextsign = map[nx][ny] == '(' ? 0 : 1;
                        int cost = sign == nextsign ? a : b;

                        if (dist[nx][ny] > currdist + cost) {
                            dist[nx][ny] = currdist + cost;
                            queue.add(new int[] { nextsign, nx, ny, dist[nx][ny] });
                        }
                    }
                }

                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < N; y++) {
                        answer = Math.max(answer, dist[x][y]);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}