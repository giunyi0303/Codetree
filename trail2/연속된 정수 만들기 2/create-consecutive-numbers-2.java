import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
       
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }
         Arrays.sort(arr);

        if (arr[2] - arr[1] == 1 && arr[1] - arr[0] == 1) {
            System.out.println(0);
        } else if (arr[2] - arr[1] == 2 || arr[1] - arr[0] == 2) {
            System.out.println(1);

        } else {
            System.out.println(2);
        }

    }
}
