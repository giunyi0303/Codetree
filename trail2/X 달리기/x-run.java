import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        int time = 1;

        while (true) {
            long maxDistance;

            if (time % 2 == 0) {
                long k = time / 2;
                maxDistance = k * (k + 1);
            } else {
                long k = (time + 1) / 2;
                maxDistance = k * k;
            }

            if (maxDistance >= x) {
                System.out.println(time);
                break;
            }

            time++;
        }
    }
}