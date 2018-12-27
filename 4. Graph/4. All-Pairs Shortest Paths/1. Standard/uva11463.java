import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=1;i<=T;i++){
            int N = Integer.parseInt(br.readLine());
            int R = Integer.parseInt(br.readLine());
            int g[][] = new int[N][N];
            for(int j=0;j<N;j++){
                Arrays.fill(g[j],10000);
                g[j][j] = 0;
            }
            StringTokenizer st;
            for(int j=0;j<R;j++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                g[u][v] = 1;
                g[v][u] = 1;
            }
            for(int k=0;k<N;k++){
                for(int u=0;u<N;u++){
                    for(int v=0;v<N;v++){
                        g[u][v] = Math.min(g[u][v],g[u][k]+g[k][v]);
                    }
                }
            }
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int max = 0;
            for(int j=0;j<N;j++){
                max = Math.max(max,g[start][j]+g[j][end]);
            }
            System.out.printf("Case %d: %d\n",i,max);
        }
    }
}