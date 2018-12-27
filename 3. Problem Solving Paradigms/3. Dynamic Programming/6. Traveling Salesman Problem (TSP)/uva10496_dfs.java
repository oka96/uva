// Implementation TSP by DFS
// (more slower) 0.08s
import java.util.*;
import java.io.*;

public class Main {
    public static Grid start;
    public static Grid prev;
    public static Grid travel[];
    public static boolean visited[][];
    public static int N;
    public static int min;
    public static void dfs(int sum,int n){
        if(n==N){
            int dist = Math.abs(start.r-prev.r)+Math.abs(start.c-prev.c);
            min = Math.min(min,sum+dist);
        }
        for(int i=0;i<N;i++){
            Grid hold = new Grid(prev.r,prev.c);
            Grid cur = travel[i];
            if(visited[cur.r][cur.c])
                continue;
            int dist = Math.abs(cur.r-prev.r)+Math.abs(cur.c-prev.c);
            if(sum+dist>=min)
                continue;
            visited[cur.r][cur.c] = true;
            prev = new Grid(cur.r,cur.c);
            dfs(sum+dist,n+1);
            prev = new Grid(hold.r,hold.c);
            visited[cur.r][cur.c] = false;            
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            visited = new boolean[x][y];
            min = Integer.MAX_VALUE;
            
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            
            start = new Grid(r,c);
            N = Integer.parseInt(br.readLine());
            travel = new Grid[N];
            
            for(int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken())-1;
                int v = Integer.parseInt(st.nextToken())-1;
                travel[j] = new Grid(u,v);
            }
            for(int j=0;j<N;j++){
                Grid cur = travel[j];
                visited[cur.r][cur.c] = true;
                int dist = Math.abs(start.r-cur.r)+Math.abs(start.c-cur.c);
                prev = new Grid(cur.r,cur.c);
                dfs(dist,1);
                visited[cur.r][cur.c] = false;
            }
            System.out.printf("The shortest path has length %d\n",min);
        }
    }
}

class Grid{
    int r;
    int c;
    Grid(int r,int c){
        this.r = r;
        this.c = c;
    }
}