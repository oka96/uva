import java.util.*;
import java.io.*;
public class Main {
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s ;
        int line = 0;
        while(!(s=br.readLine()).equals("*")){
            line++;
            switch(s){
                case "Hajj":    System.out.printf("Case %d: Hajj-e-Akbar\n",line);   break;
                case "Umrah":   System.out.printf("Case %d: Hajj-e-Asghar\n",line);   break;
            }
        }
        
       
    }
}
