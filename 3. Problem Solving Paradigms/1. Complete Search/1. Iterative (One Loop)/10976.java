import java.util.*;
import java.io.*;
public class Main {      
    
    public static void main(String[] args)throws IOException{   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        
        while((s=br.readLine())!=null&&!s.isEmpty()){
            int k = Integer.parseInt(s);
            ArrayList<Integer> pair = new ArrayList<>();
            
            for(int i=1;i<=k;i++){
                if(k*k%i==0){
                    pair.add(i);
                }
            }
            
            System.out.println(pair.size());
            
            while(!pair.isEmpty()){
                int t = pair.remove(0);
                int y = t+k;
                int x = k*k/t+k;
                System.out.printf("1/%d = 1/%d + 1/%d\n",k,x,y);
            }            
        }       
    }
}