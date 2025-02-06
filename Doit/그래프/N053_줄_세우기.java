package Doit.그래프;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N053_줄_세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer>[] students = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            students[i] = new ArrayList<>();
        }
        int[] inDegree = new int[N+1];  // 진입차수 배열
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            students[a].add(b); // 키: a < b
            inDegree[b]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        // 키 작은 애들부터 넣기 (진입 차수 작은 애들부터)
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int next : students[now]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}
