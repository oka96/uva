import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine())!=null){
            if(s.equals("0 0")){
                break;
            }
            StringTokenizer st = new StringTokenizer(s);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int reg[][] = new int[N][M];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    reg[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int Q = Integer.parseInt(br.readLine());
            for(int i=0;i<Q;i++){
                st = new StringTokenizer(br.readLine());                
                int L = Integer.parseInt(st.nextToken());
                int U = Integer.parseInt(st.nextToken());               
                int row[] = new int[N];                
                Arrays.fill(row,-1);
                
                for(int j=0;j<N;j++){
                    int low = 0;
                    int high = M-1;
                    while(low<=high){
                        int mid = (low+high)/2;
                        if(reg[j][mid]<L){
                            low = mid+1;
                        }else{
                            high = mid-1;
                            if (reg[j][mid]<=U){
                                row[j] = mid;
                            }
                        }
                    }
                }
                int maxSquare = 0;
                for(int j=0;j<N;j++){
                    if(row[j]==-1)
                        continue;
                    int low = 0;
                    int size = Math.min(N-j,M-row[j]);
                    int high = size-1;
                    int max = -1;
                    while(low<=high){
                        int mid = (low+high)/2;
                        if(reg[j+mid][row[j]+mid]>U){
                            high = mid-1;
                        }else{
                            low = mid+1;
                            max = mid;
                        }
                    }
                    maxSquare = Math.max(maxSquare,max+1);
                }
                System.out.println(maxSquare);
            }
            System.out.println("-");
        }
    }
}