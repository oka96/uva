import java.util.*;
import java.io.*;
public class Main {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
         int T =in.nextInt();
         
         for(int i=0;i<T;i++){
             int N = in.nextInt();
             int max = 0;
             for(int j=0;j<N;j++){
                 max = Math.max(max,in.nextInt());
             }    
             System.out.printf("Case %d: %d\n",i+1,max);
         }
    
    }
}
