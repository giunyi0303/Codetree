import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<double[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new double[] { w, c, (double) c / w });
        }

        list.sort((o1, o2) -> Double.compare(o2[2], o1[2]));

        double cost = 0;
        double count = M;

        for (double[] temp : list) {
            if (count >= temp[0]) {
                cost += temp[1];
                count -= temp[0];
            } else {
                cost += temp[2] * count;
                break;
            }
        }

        System.out.printf("%.3f%n", cost);
    }
}
