import java.util.*;
import java.io.*;
public class Main {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int B = 0; int N = 0;

        
        while((B=in.nextInt())!=0&&(N=in.nextInt())!=0){
            
            int bank[] = new int[B];
            
            for(int i=0;i<B;i++){
                bank[i] = in.nextInt();
            }
            
            for(int i=0;i<N;i++){
                int debtor = in.nextInt();
                int creditor = in.nextInt();
                int amount = in.nextInt();
                bank[debtor-1] -= amount;
                bank[creditor-1] += amount;
            }
            
            boolean GG = false;
            for(int i=0;i<B;i++){
                if(bank[i]<0){
                    GG = true;
                    break;
                }
            }
            
            if(GG){
                System.out.println("N");
            }else{
                System.out.println("S");
            }
            
        }
        
    }
}
