import java.util.*;
import java.io.*;
public class Main {
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int line = 0;
        while(!(s=br.readLine()).equals("#")){
            line++;
            switch(s){
                case "HELLO":   System.out.printf("Case %d: %s\n",line,"ENGLISH"); break;
                case "HOLA":    System.out.printf("Case %d: %s\n",line,"SPANISH"); break;
                case "HALLO":   System.out.printf("Case %d: %s\n",line,"GERMAN"); break;
                case "BONJOUR": System.out.printf("Case %d: %s\n",line,"FRENCH"); break;
                case "CIAO":    System.out.printf("Case %d: %s\n",line,"ITALIAN"); break;
                case "ZDRAVSTVUJTE":    System.out.printf("Case %d: %s\n",line,"RUSSIAN"); break;
                default:
                    System.out.printf("Case %d: %s\n",line,"UNKNOWN");   
            }
        }
    }
}
