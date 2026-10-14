import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n];
        int[] e = new int[n];
        ArrayList<int []> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
            e[i] = sc.nextInt();
            list.add(new int [] {s[i],e[i]});
        }
        list.sort((o1, o2) -> {
        if (o1[1] == o2[1]) {
        return Integer.compare(o1[0], o2[0]);
        }
        return Integer.compare(o1[1], o2[1]);});
        int curr = 0;
        int count = 0;
        for(int [] temp : list)
        {
            if(curr<=temp[0])
            {
                count++;
                curr = temp[1];
            }
        }
        System.out.println(count);
        
    }
}