import java.util.*;
import java.io.*;
public class Main {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            int sum = 0;
            int f = in.nextInt();
            for(int j=0;j<f;j++){
                int a = in.nextInt();
                in.nextInt();
                int c = in.nextInt();
                sum += a*c;
            }            
            System.out.println(sum);
        }   
    }
}