package Doit.그래프;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class N047_효율적으로_해킹하기 {
    static boolean[] visited;
    static ArrayList<Integer>[] network;
    static int N;
    static int M;
    static int[] hacking;   // 시작 위치별 해킹 가능한 컴퓨터 개수

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = sc.nextInt();
        M = sc.nextInt();
        network = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            network[i] = new ArrayList<>();
        }
        // 네트워크 정보 초기화
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // a가 b를 신뢰 -> b 해킹하면 a도 해킹 가능
            network[b].add(a);
        }
        // 모든 시작점에서 확인
        int maxValue = 0;
        hacking = new int[N+1];
        for (int v = 1; v <= N; v++) {
            hacking[v] = bfs(v);
            if (maxValue < hacking[v]) {
                maxValue = hacking[v];
            }
        }
        // 가장 많은 컴퓨터 해킹할 수 있는 컴퓨터 번호
        for (int i = 1; i <= N; i++) {
            if (hacking[i] == maxValue) {
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
    }

    private static int bfs(int start) {
        visited = new boolean[N+1];
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            count++;
            for (int next : network[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return count;
    }
}
