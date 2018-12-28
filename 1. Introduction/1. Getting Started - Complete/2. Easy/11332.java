import java.util.*;
import java.io.*;
public class Main {
    public static int g(int n){
        if(Math.log10(n)<1)
            return n;
        else{
            int b = 0;

            while(n!=0){
                b += n%10;
                n = (n-(n%10))/10;
            }
            return g(b);
        }
           
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner (System.in);
        
        while(true){
            int n = in.nextInt();
            if(n==0){
                break;
            }else{
                System.out.println(g(n));
            }
        }
        
    }
}
