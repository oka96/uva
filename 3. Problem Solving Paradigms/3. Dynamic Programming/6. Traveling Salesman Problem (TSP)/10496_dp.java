// Implementation using TSP Dynamic Programming
// (more faster) 0.05s
import java.util.*;
import java.io.*;

public class Main {
    public static Grid g[];
    public static boolean bit(int i,int num){
        int v = num&(1<<i);
        return v>0;
    }
    public static int d(int i,int j){
        Grid p1 = g[i];
        Grid p2 = g[j];
        return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(br.readLine());
            g = new Grid[N+1];
            g[0] = new Grid(sx,sy);
            for(int j=1;j<=N;j++){
                st = new StringTokenizer(br.readLine());
                int px = Integer.parseInt(st.nextToken());
                int py = Integer.parseInt(st.nextToken());
                g[j] = new Grid(px,py);
            }
            int dp[][] = new int[N+1][1<<(N+1)];
            for(int j=0;j<=N;j++){
                Arrays.fill(dp[j],Integer.MAX_VALUE);
            }
            dp[0][0] = 0;
            for(int j=0;j<1<<(N+1);j++){
                for(int k=0;k<=N;k++){
                    if(bit(k,j)){
                        int mask = j^(1<<k);
                        for(int m=0;m<=N;m++){
                            if(dp[m][mask]!=Integer.MAX_VALUE){
                                int dist = d(m,k);
                                dp[k][j] = Math.min(dp[k][j],dp[m][mask]+dist);
                            }
                        }
                    }
                }
            }
            System.out.printf("The shortest path has length %d\n",dp[0][(1<<N+1)-1]);
        }
    }
}

class Grid{
    int x;
    int y;
    Grid(int x,int y){
        this.x = x;
        this.y = y;
    }
}
