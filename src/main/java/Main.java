import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int N;
    static int[] student;
    static boolean[] done;
    static boolean[] visited;
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-->0){
            N = Integer.parseInt(br.readLine());
            count=0;
            student = new int[N+1];
            visited = new boolean[N+1];
            done = new boolean[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++){
                student[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=1;i<=N;i++){
                if(!done[i]){
                    dfs(i);
                }
            }

            System.out.println(N-count);
        }


    }

    private static void dfs(int i) {
        if(visited[i]){
            done[i] = true;
            count++;
        }else {
            visited[i] = true;
        }

        if(!done[student[i]]){
            dfs(student[i]);
        }

        visited[i] = false;
        done[i] = true;

    }

}
