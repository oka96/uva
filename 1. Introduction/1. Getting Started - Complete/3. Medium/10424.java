import java.util.*;
import java.io.*;
public class Main {
    public static int cal(int n){
        if(Math.log10(n)>=1){
            int r = 0;
            while(n!=0){
                r += n%10;
                n /= 10;
            }
            return cal(r);
        }else{
            return n;
        }
    }
    
    public static float val(String s1,String s2){
        int c1 = 0;
        int c2 = 0;
        
        for(int i=0;i<s1.length();i++){
            int a = (int)s1.charAt(i)-'a'+1;
            if(a<=26&&a>=1){
                c1 += a;
            }
        }    
        
        for(int i=0;i<s2.length();i++){
            int a = (int)s2.charAt(i)-'a'+1;
            if(a<=26&&a>=1){
                c2 += a;
            }
        } 
        int min = Math.min(cal(c1),cal(c2));
        int max = Math.max(cal(c1),cal(c2));
        return ((float)min/max)*100;
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine())!=null){
            System.out.printf("%.2f %%\n",val(s.toLowerCase(),br.readLine().toLowerCase()));
        }
    }
}