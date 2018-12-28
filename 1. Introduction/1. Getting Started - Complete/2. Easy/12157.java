import java.util.*;
import java.io.*;
public class Main {
    public static int cost(int [] c,String type){
        if(type.equals("Mile")){
            int cost = 0;
            for(int i=0;i<c.length;i++){
                cost += (c[i]/30+1)*10;
            }
            return cost;
        }else if(type.equals("Juice")){
            int cost = 0;
            for(int i=0;i<c.length;i++){
                cost += (c[i]/60+1)*15;
            }
            return cost;
        }
        return -1;
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();
        
        for(int i=0;i<T;i++){
            int N = in.nextInt();
            int call[] = new int[N];
            
            for(int j=0;j<N;j++){
                call[j] = in.nextInt();
            }
            
            if(cost(call,"Mile")==cost(call,"Juice")){
                System.out.printf("Case %d: Mile Juice %d\n",i+1,cost(call,"Mile"));
            }else if(cost(call,"Mile")<cost(call,"Juice")){
                System.out.printf("Case %d: Mile %d\n",i+1,cost(call,"Mile"));
            }else{
                System.out.printf("Case %d: Juice %d\n",i+1,cost(call,"Juice"));
            }      
            
        }
        
        
    }
}