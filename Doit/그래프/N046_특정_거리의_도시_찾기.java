package Doit.그래프;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class N046_특정_거리의_도시_찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int X = sc.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        // 도시 정보 초기화
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            graph[start].add(end);
        }

        int[] distance = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(X);
        visited[X] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[now] + 1;
                    queue.add(next);
                }
            }
        }
        boolean hasAnswer = false;
        for (int i = 0; i <= N; i++) {
            // 오름차순 출력
            if (distance[i] == K) {
                hasAnswer = true;
                System.out.println(i);
            }
        }
        if (!hasAnswer)
            System.out.println(-1);
    }
}
