// time: 4s ++
import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static double path[][];
    public static double prices[];
    public static boolean visited[];
    public static double min;
    public static int home = 0;
    public static int prev;
    public static int none;
    public static double left;
    public static void dfs(double sum,int n){
        if(n==N-none){
            if(path[prev][home]==-1.0)
                return;
            min = Math.min(min,sum+path[prev][home]);
            return;
        }
        if(path[prev][home]!=-1){
            min = Math.min(min,sum+left+path[prev][home]);
        }

        for(int i=0;i<N;i++){
            
            if(visited[i])
                continue;
            if(path[prev][i]==-1){
                continue;
            }
            if(sum+path[prev][i]>=min)
                continue;
            double curLeft = left;
            int hold = prev;
            visited[i] = true;
            prev = i;
            left = left-prices[i];
            dfs(sum+path[hold][i],n+1);
            left = curLeft;
            prev = hold;
            visited[i] = false;        
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken())+1;
            int M = Integer.parseInt(st.nextToken());
            path = new double[N][N];
            visited = new boolean[N];
            for(int j=0;j<N;j++){
                Arrays.fill(path[j],-1.0);
            }
            for(int j=0;j<M;j++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                double w = Double.parseDouble(st.nextToken());
                if(path[u][v]==-1){
                    path[u][v] = w;
                    path[v][u] = w;
                }else{
                    path[u][v] = Math.min(path[u][v], w);
                    path[v][u] = path[u][v];
                }
            }
            for(int j=0;j<N;j++){
                path[j][j] = 0.0;
            }
            
            //generate all pair shortest path
            for(int k=0;k<N;k++){
                for(int u=0;u<N;u++){
                    for(int v=0;v<N;v++){
                        if(path[u][k]==-1)
                            continue;
                        if(path[k][v]==-1)
                            continue;
                        double dist = path[u][k]+path[k][v];
                        if(path[u][v]==-1)
                            path[u][v] = dist;
                        else
                            path[u][v] = Math.min(path[u][v],dist);
                    }
                }
            }
            
            int P = Integer.parseInt(br.readLine());
            prices = new double[N];
            Arrays.fill(prices,-1.0);
            for(int j=0;j<P;j++){
                st = new StringTokenizer(br.readLine());
                int shop = Integer.parseInt(st.nextToken());
                double price = Double.parseDouble(st.nextToken());
                if(prices[shop]==-1)
                    prices[shop] = price;
                else
                    prices[shop] += price;
            }
            double amazon = 0;
            none = 0;
            for(int j=0;j<N;j++){
                if(prices[j]!=-1){
                    amazon += prices[j];
                }else{
                    none++;
                    visited[j] = true;
                }
            }
            min = amazon;
            left = amazon;
            for(int j=0;j<N;j++){
                if(visited[j])
                    continue;
                if(path[0][j]==-1)
                    continue;
                visited[j] = true;
                prev = j;
                left -= prices[j];
                dfs(path[0][j],1);
                left += prices[j];
                prev = 0;
                visited[j] = false;
            }
            double diff = amazon-min;

            // lol amazon-min==0, uva judge will have error lol
            if(amazon-min<1e-9){
                System.out.println("Don't leave the house");
            }else{
                System.out.printf("Daniel can save $%.2f\n",diff);
            }
        }
    }
}
