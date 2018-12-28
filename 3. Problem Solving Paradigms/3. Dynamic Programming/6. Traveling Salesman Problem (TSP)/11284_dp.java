// time: 0.34s
import java.util.*;
import java.io.*;

public class Main {
    public static boolean bit(int i,int num){
        int v = (num&(1<<i));
        return v>0;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken())+1;
            int M = Integer.parseInt(st.nextToken());
            double path[][] = new double[N][N];
            for(int j=0;j<N;j++){
                Arrays.fill(path[j],Integer.MAX_VALUE);
            }          
            for(int j=0;j<M;j++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                double w = Double.parseDouble(st.nextToken());
                path[u][v] = Math.min(path[u][v],w);
                path[v][u] = path[u][v];
            }
            for(int j=0;j<N;j++){
                path[j][j] = 0;
            }
            
            // generate All Pair Shortest Path
            for(int k=0;k<N;k++){
                for(int u=0;u<N;u++){
                    for(int v=0;v<N;v++){
                        if(path[u][k]==Integer.MAX_VALUE)
                            continue;
                        if(path[k][v]==Integer.MAX_VALUE)
                            continue;
                        path[u][v] = Math.min(path[u][v],path[u][k]+path[k][v]);
                    }
                }
            }            
            int P = Integer.parseInt(br.readLine());
            double price[] = new double[N];
            Arrays.fill(price,-1);
            for(int j=0;j<P;j++){
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                double pr = Double.parseDouble(st.nextToken());
                price[p] = Math.max(price[p],pr);
            }
            double amazon = 0;
            int count = 0;
            for(int j=0;j<N;j++){
                if(price[j]!=-1){
                    amazon += price[j];
                    count++;
                }
            }
            int size = count+1;
            int shop[] = new int[size];
            shop[0] = 0;//home
            int index = 0;
            for(int j=0;j<N;j++){
                if(price[j]!=-1){
                    index++;
                    shop[index] = j;                    
                }
            }
            double dp[][] = new double[size][1<<size];
            for(int j=0;j<size;j++){
                Arrays.fill(dp[j],Integer.MAX_VALUE);
            }
            dp[0][0] = 0;
       
            int full = (1<<size)-1;
            for(int j=0;j<1<<size;j++){
                for(int k=0;k<size;k++){
                    if(bit(k,j)){
                        int mask = j^(1<<k);
                        for(int m=0;m<size;m++){
                            if(dp[m][mask]==Integer.MAX_VALUE)
                                continue;
                            if(path[shop[m]][shop[k]]==Integer.MAX_VALUE)
                                continue;
                            dp[k][j] = Math.min(dp[k][j],dp[m][mask]+path[shop[m]][shop[k]]);                           
                        }
                    }
                }
            }
            double ans = dp[0][(1<<size)-1];
            for(int j=0;j<1<<size;j++){
                double total = 0;
                int inv = full^j;
                for(int k=1;k<size;k++){
                    if(bit(k,inv)){
                        total += price[shop[k]];
                    }
                }
                ans = Math.min(ans,dp[0][j]+total);
            }
            double diff = amazon-ans;
            if(diff<1e-9){
                System.out.println("Don't leave the house");
            }else{
                System.out.printf("Daniel can save $%.2f\n",diff);
            }
        }
    }
}
