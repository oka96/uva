import java.util.*;
import java.io.*;
public class Main {
    public static int p(int n){
        int a = ((((n*567)/9)+7492)*235/47)-498;
        int b = a%100;
        return  Math.abs(b/10);
    }
    
    public static void main(String[] args){
       Scanner in = new Scanner(System.in);
       
       int n = in.nextInt();
       
       for(int i=0;i<n;i++){
           System.out.println(p(in.nextInt()));
       }
    }
}
