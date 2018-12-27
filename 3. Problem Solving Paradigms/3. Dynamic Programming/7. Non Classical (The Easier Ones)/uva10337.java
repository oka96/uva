import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){;
            String s = br.readLine();
            while(s.isEmpty()){
                s = br.readLine();
            }
            int X = Integer.parseInt(s);
            int D = X/100;
            int g[][] = new int[D][10];
            for(int j=9;j>=0;j--){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0;k<D;k++){
                    g[k][j] = Integer.parseInt(st.nextToken());
                }
            }
            int dp[][] = new int[D+1][10];
            for(int j=0;j<=D;j++){
                Arrays.fill(dp[j],Integer.MAX_VALUE);
            }
            dp[0][0] = 0;
            for(int j=1;j<=D;j++){
                for(int k=0;k<10;k++){
                    if(dp[j-1][k]!=Integer.MAX_VALUE){
                        dp[j][k] = Math.min(dp[j][k],dp[j-1][k]+30-g[j-1][k]);
                    }
                    if(k-1>=0&&dp[j-1][k-1]!=Integer.MAX_VALUE){
                        dp[j][k] = Math.min(dp[j][k],dp[j-1][k-1]+60-g[j-1][k-1]);
                    }
                    if(k+1<=9&&dp[j-1][k+1]!=Integer.MAX_VALUE){
                        dp[j][k] = Math.min(dp[j][k],dp[j-1][k+1]+20-g[j-1][k+1]);
                    }
                }
            }
            System.out.println(dp[D][0]);
            System.out.println();
        }
    }
}
