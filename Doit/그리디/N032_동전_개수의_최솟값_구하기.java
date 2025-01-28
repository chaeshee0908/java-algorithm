package Doit.그리디;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class N032_동전_개수의_최솟값_구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int goal = sc.nextInt();
        Integer[] coins = new Integer[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins, Collections.reverseOrder());
        int answer = 0;
        for (int coin : coins) {
            if (coin > goal)
                continue;
            answer += goal / coin;
            goal = goal % coin;
        }
        System.out.println(answer);
    }
}
