import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args)throws IOException{
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(s);
            int p0 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int p3 = Integer.parseInt(st.nextToken());
            int turn = 0;
            //1
            turn += 80;
            //2
            if(p0==0&&p1==0&&p2==0&&p3==0)
                return;
            
            if(p1<p0){
                turn += (p0-p1);
            }else{
                turn += 40-(p1-p0);
            }
            //3
            turn += 40;
            //4
            if(p2>p1){
                turn += (p2-p1);
            }else{
                turn += 40-(p1-p2);
            }
            //5
            if(p3<p2){
                turn += (p2-p3);
            }else{
                turn += 40-(p3-p2);
            }
            System.out.println(turn*9);        
        }
    
    
    }
}
