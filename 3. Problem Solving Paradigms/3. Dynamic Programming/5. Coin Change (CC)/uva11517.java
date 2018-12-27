import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int v = Integer.parseInt(br.readLine());
            int dp[] = new int[10001];
            Arrays.fill(dp,Integer.MAX_VALUE);
            int N = Integer.parseInt(br.readLine());
            dp[0] = 0;
            for(int j=0;j<N;j++){
                int token = Integer.parseInt(br.readLine());
                for(int k=10000;k>=token;k--){
                    if(dp[k-token]!=Integer.MAX_VALUE)
                        dp[k] = Math.min(dp[k],dp[k-token]+1);
                }
            }
            for(int j=v;j<=10000;j++){
                if(dp[j]!=Integer.MAX_VALUE){
                    System.out.println(j+" "+dp[j]);
                    break;
                }
            }
        }
    }
}
