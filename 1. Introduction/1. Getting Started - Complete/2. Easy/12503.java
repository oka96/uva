import java.util.*;
import java.io.*;
public class Main {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
         int T = in.nextInt();
         
         for(int i=0;i<T;i++){
             int n = in.nextInt();
             String op[] = new String[n];
             for(int j=0;j<n;j++){
                String operation = in.next();
                if(operation.equals("SAME")){
                    in.next();
                    op[j] = op[in.nextInt()-1];
                }else{
                    op[j] = operation;
                }                  
             }
             int position = 0;
             for(int j=0;j<n;j++){
                 switch(op[j]){
                     case "LEFT": position--; break;
                     default : position++; break;
                 }    
             }
             System.out.println(position);
         }
        
            
       
        
    }
}
