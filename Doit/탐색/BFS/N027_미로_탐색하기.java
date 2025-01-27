package Doit.탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N027_미로_탐색하기 {
    static int[][] maze;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        // 미로 값 넣기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            char[] charArray = line.toCharArray();
            for (int j = 0; j < M; j++) {
                maze[i][j] = charArray[j] - '0';   // 숫자로 변환
            }
        }
        // bfs
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 미로 내부가 아닌 경우 제외
                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                // 가지 못하는 길인 경우 제외: '0'인 경우
                if (maze[nx][ny] == 0)
                    continue;
                if (maze[nx][ny] == 1 || maze[nx][ny] > maze[x][y] + 1) {
                    maze[nx][ny] = maze[x][y] + 1;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        System.out.println(maze[N-1][M-1]);
    }
}
