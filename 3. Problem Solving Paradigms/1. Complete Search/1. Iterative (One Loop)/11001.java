import java.util.*;
import java.io.*;
public class Main {      
    // p = 0.3 sqrt(v-v0);
    // p_total = 0.3k(v/k-v0);
    // dp_total/dk = 0, v-2kv0 = 0;
    // check uniqueness
    // p_k0 = p_k1
    // v = (k0+k1)v0
    // If v0|v, else unique.
    // v0|v, if k0 = k1, unique, else not unique
    public static void main(String[] args)throws IOException{   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        
        while(!(s=br.readLine()).equals("0 0")){
            StringTokenizer st = new StringTokenizer(s);
            int vt = Integer.parseInt(st.nextToken());
            int v0 = Integer.parseInt(st.nextToken());
            if(vt<=v0){
                System.out.println("0");
            }else{
                int k0 = (int)Math.round((double)vt/(2*v0));
                if(k0>1){
                    if(vt%v0==0){
                        int q = vt/v0;
                        if(k0==q-k0){
                            System.out.println(k0);
                        }else{
                            System.out.println("0");
                        }
                    }else{
                        System.out.println(Math.round((double)vt/(2*v0)));
                    }
                }else{
                    System.out.println("0");
                }
            }
        }
    }
}