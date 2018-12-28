import java.util.*;
import java.io.*;
public class Main {      

    public static void main(String[] args)throws IOException{   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0;i<T;i++){
            int k = Integer.parseInt(br.readLine());
            int mark[] = new int[k];
            
            for(int j=0;j<k;j++){
                mark[j] = Integer.parseInt(br.readLine());
            }
            
            int max = Integer.MIN_VALUE;
            int target = mark[0];
            for(int j=0;j<k-1;j++){
                target = Math.max(target,mark[j]);
                max = Math.max(max,target-mark[j+1]);
            }
            
            System.out.println(max);
        }
    }
}
