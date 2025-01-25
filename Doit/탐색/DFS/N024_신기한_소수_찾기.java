package Doit.탐색.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class N024_신기한_소수_찾기 {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        // 일의 자리 소수는 2, 3, 5, 7 뿐
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    static void dfs(int n, int depth) {
        // 신기한 소수 경우
        if (isPrimeNumber(n) && depth == N) {
            System.out.println(n);
            return;
        }
        // 조건이 충족하지 않는 경우
        if (!isPrimeNumber(n)) {
            return;
        }
        for (int i = 0; i <= 9; i++) {
            dfs(n * 10 + i, depth+1);
        }
    }

    static boolean isPrimeNumber(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
