import java.util.*;
import java.io.*;
public class Main {  
    
    public static boolean round(int[]n){
        boolean select[] = new boolean[n.length];
        int target = 0;
        
        for(int i=0;i<n.length;i++){
            if(!select[target]){
                select[target] = true;
                target = (target+n[target]) % n.length;
            }else{
                return false;
            }
        }
        
        if(n[target]==n[0]){
            return true;
        }else{
            return false;
        }
    }
    
    public static int[] number(int n){
        int digit = (int)Math.log10(n)+1;
        int num[] = new int[digit];
        
        if(n==0){
            num[0] = 0;
        }else{
            int ptr = digit-1;
            while(n!=0){
                num[ptr] = n%10;
                n /= 10;
                ptr--;
            }
        }       
        return num;
    }    
    
    public static boolean distinct(int n[]){
        boolean num[] = new boolean[10];
        for(int i=0;i<n.length;i++){
            if(num[n[i]]){
                return false;
            }else{
                num[n[i]] = true;
            }
        }
        return true;
    }
    
    public static void main(String[] args)throws IOException{   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int line = 0;
        ArrayList<Integer> data = new ArrayList<>();

        for(int i=1;i<10000000;i++){           
            int n[] = number(i);
            if(distinct(n)&&round(n)){
                data.add(i);
            }
        }

        while((s=br.readLine())!=null&&!s.equals("0")){
            line++;
            int n = Integer.parseInt(s);
            for(int i=0;i<data.size();i++){
                if(data.get(i)>n){
                    System.out.printf("Case %d: %d\n",line,data.get(i));
                    break;
                }
            }
        }
        
    }
}