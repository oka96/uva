import java.util.*;
import java.io.*;
public class Main {      
    
    public static void main(String[] args)throws IOException{   
        int data [] = new int[10000];
        String database[][] = new String[4][10000];
        int count [] = new int [4];
        
        for(int i=0;i<10000;i++){
            data[i] = i*i;
        }
        
        for(int i=1;i<=4;i++){
            for(int j=0;j<Math.pow(10,i);j++){
                int q = data[j]/(int)Math.pow(10,i);
                int r = data[j]%(int)Math.pow(10,i);
                if((q+r)*(q+r)==data[j]){
                    database[i-1][count[i-1]] = String.format("%0"+(2*i)+"d",data[j]);
                    count[i-1]++;
                }    
            }
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s ;
        
        while((s=br.readLine())!=null&&!s.isEmpty()){
            int n = Integer.parseInt(s);
            for(int i=0;i<count[n/2-1];i++){
                System.out.println(database[n/2-1][i]);
            }
        }
        
    }
}