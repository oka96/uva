import java.util.*;
import java.io.*;
public class Main {     
    public static void main(String[] args){   
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for(int i=1;i<=T;i++){
            int n = in.nextInt();
            int a[] = new int[n];
            for(int j=0;j<n;j++){
                a[j] = in.nextInt();
            }
            int count = 0;
            for(int j=1;j<n;j++){
                for(int k=j-1;k>=0;k--){
                    if(a[j]>=a[k]){
                        count++;
                    }    
                }    
            }
            System.out.println(count);
        }
        
    }
}