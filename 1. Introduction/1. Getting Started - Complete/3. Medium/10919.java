import java.util.*;
import java.io.*;
public class Main {    
    public static boolean check(String select[],String c){
        for(int i=0;i<select.length;i++){
            if(select[i].equals(c)){
                return true;
            } 
        }
        return false;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while(!(s=br.readLine()).equals("0")){
            StringTokenizer st = new StringTokenizer(s);
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            String select[] = new String[k];
            for(int i=0;i<k;i++){
                select[i] = st2.nextToken();
            }
            
            boolean fulfill = true;
            for(int x=0;x<m;x++){
                StringTokenizer st3 = new StringTokenizer(br.readLine());

                int total = Integer.parseInt(st3.nextToken());
                int target = Integer.parseInt(st3.nextToken());
                int count=0;

                for(int i=0;i<total;i++){
                    if(check(select,st3.nextToken())){
                        count++;
                    }
                }
                if(count<target){
                    fulfill = false;
                }    
            }
            if(fulfill){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
            
                   
        }    
    }
}