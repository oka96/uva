import java.util.*;
import java.io.*;
public class Main {     
    public static void main(String[] args){   
        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();
        
        for(int i=1;i<=T;i++){
            int n = in.nextInt();
            int k = in.nextInt();
            char word[] = in.next().toCharArray();
            int count = 0;
            for(int j=0;j<n-1;j++){
                for(int m=j+1;m<=j+k&&m<n;m++){
                    if(word[j]==word[m]){
                        count++;
                        break;
                    }
                }
            }
            System.out.printf("Case %d: %d\n",i,count);
        }       
    }
}