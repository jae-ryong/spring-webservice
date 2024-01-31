import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] bridge;
    static boolean[][] visited;
    static boolean[][] check;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static int answer = Integer.MAX_VALUE;
    static class Point{
        int x, y, val;
        Point(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bridge = new int[N][N];
        check = new boolean[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                bridge[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!check[i][j] && bridge[i][j]==1){
                    bfs(i,j);
                }
            }
        }

        System.out.println(answer);


    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y,0));
        check[x][y] = true;
        while (!queue.isEmpty()){
            Point a = queue.poll();
            for(int i=0;i<4;i++){
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(bridge[nx][ny]==0 || check[nx][ny]) continue;
                queue.add(new Point(nx,ny,0));
                check[nx][ny]= true;
            }
        }

        queue = new LinkedList<>();
        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(check[i][j]){
                    queue.add(new Point(i,j,0));
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()){
            Point b= queue.poll();
            for (int i=0;i<4;i++){
                int nx = b.x + dx[i];
                int ny = b.y + dy[i];
                if(nx<0 || ny<0|| nx>=N || ny>=N) continue;
                if(visited[nx][ny]) continue;
                if(bridge[nx][ny]==1){
                    answer = Math.min(b.val,answer);
                    continue;
                }
                queue.add(new Point(nx,ny,b.val+1));
                visited[nx][ny] = true;
            }
        }


    }

}
