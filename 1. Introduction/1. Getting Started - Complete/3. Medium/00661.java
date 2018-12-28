import java.util.*;
import java.io.*;
public class Main {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int n = 0;
        int m = 0;
        int c = 0;
        
        int line = 0;
        
        while((n=in.nextInt())!=0&&(m=in.nextInt())!=0&&(c=in.nextInt())!=0){
            line++;
            
            int device[] = new int [n];
            boolean state[] = new boolean[n];
                      
            int ampere = 0;
            int max = 0;
            
            for(int i=0;i<n;i++){
                device[i] = in.nextInt();
            }
            
            for(int i=0;i<m;i++){
                int target = in.nextInt()-1;
                
                if(state[target]){
                    ampere -= device[target]; // on -> off
                }else{
                    ampere += device[target];
                    max = Math.max(max,ampere);
                }
              
                state[target] = !state[target];                                 
            }
            
            System.out.printf("Sequence %d\n",line);
            if(max>c){
                System.out.printf("Fuse was blown.\n\n");
            }else{
                System.out.println("Fuse was not blown.");
                System.out.printf("Maximal power consumption was %d amperes.\n\n",max);
            }
            
        }
        
    }
}