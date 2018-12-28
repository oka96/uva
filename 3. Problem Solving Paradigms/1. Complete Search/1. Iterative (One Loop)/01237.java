import java.util.*;
import java.io.*;
public class Main {      
    
    public static void main(String[] args)throws IOException{   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =  Integer.parseInt(br.readLine());
        
        for(int i=1;i<=T;i++){
            int D = Integer.parseInt(br.readLine());
            String car[] = new String[D];
            int low[] = new int[D];
            int high[] = new int[D];
            
            for(int j=0;j<D;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                car[j] = st.nextToken();
                low[j] = Integer.parseInt(st.nextToken());
                high[j] = Integer.parseInt(st.nextToken());
            }
            
            int Q = Integer.parseInt(br.readLine());
            
            for(int j=0;j<Q;j++){
                int price = Integer.parseInt(br.readLine());
                int count = 0;
                int index = -1;
                
                for(int k=0;k<D;k++){
                    if(price<=high[k]&&price>=low[k]){
                        count++;
                        index = k;
                        if(count>1){
                            count++;
                            break;
                        }
                    }
                }
                
                if(count==1){
                    System.out.println(car[index]);
                }else{
                    System.out.println("UNDETERMINED");
                }
                
            }
            
            if(i!=T){
                System.out.println();
            }
        }
        
    }
}