package Doit.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N054_게임_개발하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] inDegree = new int[N+1];
        int[] cost = new int[N+1];
        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");
            int price = Integer.parseInt(info[0]);
            cost[i+1] = price;
            inDegree[i+1] += info.length - 2;
            for (int k = 1; k < info.length - 1; k++) {
                int f = Integer.parseInt(info[k]);
                graph[f].add(i+1);
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        }));
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(new int[]{cost[i], i});
            }
        }
        int[] answer = new int[N+1];
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            answer[now[1]] = now[0];
            for (int next : graph[now[1]]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(new int[]{now[0] + cost[next], next});
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }
}
