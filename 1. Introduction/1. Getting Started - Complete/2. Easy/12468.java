import java.util.*;
import java.io.*;
public class Main {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
       int a = 0;
       int b = 0;
       
       while((a=in.nextInt())!=-1&&(b=in.nextInt())!=-1){
           if(a<b)
                System.out.println(Math.min(b-a,100+a-b));
           else
               System.out.println(Math.min(a-b,100+b-a));
       }
            
       
        
    }
}
